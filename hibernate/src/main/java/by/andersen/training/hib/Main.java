package by.andersen.training.hib;

import by.andersen.training.hib.models.Auto;
import by.andersen.training.hib.models.User;
import by.andersen.training.hib.services.implementations.UserServiceImpl;
import by.andersen.training.hib.services.interfaces.UserService;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        User user = new User("Sasha",20);
        userService.save(user);
        Auto mustang = new Auto("Ford Mustang","Black");
        user.addAuto(mustang);
        Auto skyline = new Auto("Nissan Skyline","Gray");
        user.addAuto(skyline);
        userService.update(user);
        System.out.println(userService.findById(3L));
        String
    }

}
