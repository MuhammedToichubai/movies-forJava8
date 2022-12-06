package test.service;

import test.Meal;
import test.Person;

import java.util.List;

public interface PersonService {

    void saveCooks(List<Person> cooks);

    void saveClient(List<Person>clients);

    List<Person> getAllCooks();

    List<Person> getAllClient();

    void pay(Person person, List<Meal> meals);


}
