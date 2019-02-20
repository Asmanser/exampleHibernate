package by.andersen.training.hibernatecrud.services.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RPCServer {

    private ConnectionFactory connectionFactory = new ConnectionFactory();
    {
        connectionFactory.setHost("localhost");
    }

    public RPCServer() {
    }



    private class Runner implements Runnable {

        private ConnectionFactory factory;

        private String RPC_Queue_Name = "";

        public Runner(ConnectionFactory factory, String RPC_Queue_Name) {
            this.factory = factory;
            this.RPC_Queue_Name = RPC_Queue_Name;
        }

        public void run() {
                try (Connection connection = factory.newConnection();
                     Channel channel = connection.createChannel()) {
                    channel.queueDeclare(RPC_Queue_Name, false, false, false, null);
                    channel.queuePurge(RPC_Queue_Name);
                    channel.basicQos(1);
                    Object monitor = new Object();
                    DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                        AMQP.BasicProperties replyProps = new AMQP.BasicProperties
                                .Builder()
                                .correlationId(delivery.getProperties().getCorrelationId())
                                .build();

                        String response = "";

                        try {
                            String message = new String(delivery.getBody(), "UTF-8");
                            //int n = Integer.parseInt(message);

                            System.out.println(" [.] fib(" + message + ")");
                            response += 1;
                        } catch (RuntimeException e) {
                            System.out.println(" [.] " + e.toString());
                        } finally {
                            channel.basicPublish("", delivery.getProperties().getReplyTo(), replyProps, response.getBytes("UTF-8"));
                            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
                            // RabbitMq consumer worker thread notifies the RPC server owner thread
                            synchronized (monitor) {
                                monitor.notify();
                            }
                        }
                    };

                    channel.basicConsume(RPC_Queue_Name, false, deliverCallback, (consumerTag -> { }));
                    // Wait and be prepared to consume the message from RPC client.
                    while (true) {
                        synchronized (monitor) {
                            try {
                                monitor.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                } catch (TimeoutException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }


}


