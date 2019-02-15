package by.andersen.training.hibernatecrud.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "city_name",length = 200, nullable = false)
    private String cityName;

    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
    private List<PersonalInformation> personalInformation;

    public City() {
    }

    public City(String cityName) {
        this.cityName = cityName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<PersonalInformation> getPersonalInformation() {
        return personalInformation;
    }

    public void setPersonalInformation(List<PersonalInformation> personalInformation) {
        this.personalInformation = personalInformation;
    }
}
