package by.andersen.training.hibernatecrud.models;

import javax.persistence.*;

@Entity
@Table(name = "personal_informations")
public class PersonalInformation {

    @Id
    @Column(name = "id_user")
    private int id;

    @Column(length = 80,nullable = false)
    private String name;

    @Column(length = 80,nullable = false)
    private String surname;

    @Column(length = 80,nullable = false)
    private String patronymic;

    @Column(nullable = false)
    private int age;

    @Column(length = 100,nullable = false)
    private String email;

    @OneToOne
    @PrimaryKeyJoinColumn
    private User user;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;

    public PersonalInformation() {
    }

    public PersonalInformation(String name, String surname, String patronymic, byte age, String email) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.age = age;
        this.email = email;
    }

    public PersonalInformation(int id, String name, String surname, String patronymic, byte age, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "PersonalInformation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", user=" + user +
                ", city=" + city +
                '}';
    }
}
