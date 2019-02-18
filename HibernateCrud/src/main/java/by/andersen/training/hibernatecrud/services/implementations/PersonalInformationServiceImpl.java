package by.andersen.training.hibernatecrud.services.implementations;

import by.andersen.training.hibernatecrud.dao.implementations.PersonalInformationDAOImpl;
import by.andersen.training.hibernatecrud.dao.interfaces.PersonalInformationDAO;
import by.andersen.training.hibernatecrud.models.PersonalInformation;
import by.andersen.training.hibernatecrud.services.interfaces.PersonalInformationService;

import java.util.List;

public class PersonalInformationServiceImpl implements PersonalInformationService<PersonalInformation,Integer> {

    private PersonalInformationDAO<PersonalInformation,Integer> personalInformationDAO = new PersonalInformationDAOImpl();

    public List<PersonalInformation> getAll() {
        return personalInformationDAO.getAll();
    }

    public boolean add(PersonalInformation personalInformation) {
        return personalInformationDAO.add(personalInformation);
    }

    public boolean delete(Integer integer) {
        return personalInformationDAO.delete(integer);
    }

    public boolean update(PersonalInformation personalInformation) {
        return personalInformationDAO.update(personalInformation);
    }

    public PersonalInformation findById(Integer integer) {
        return personalInformationDAO.findById(integer);
    }
}
