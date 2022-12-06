package test.service.imp;

import test.Meal;
import test.Person;
import test.service.PersonService;

import java.util.LinkedList;
import java.util.List;

public class PersonImpl implements PersonService {

    private List<Person> cooks = new LinkedList<>();
    private List<Person> clients = new LinkedList<>() ;


    @Override
    public void saveCooks(List<Person> cooks) {
        this.cooks.addAll(cooks);

    }

    @Override
    public void saveClient(List<Person> clients) {
        this.clients.addAll(clients);
    }

    @Override
    public List<Person> getAllCooks() {
        return this.cooks;
    }

    @Override
    public List<Person> getAllClient() {
        return this.clients;
    }

    @Override
    public void pay(Person person, List<Meal> meals) {
        int summaMeals = 0;

        for (Meal meal : meals) {
            summaMeals += meal.getPrice();
        }

        int clientBalance = person.getBankAccount().getBalance() - summaMeals;
        person.getBankAccount().setBalance(clientBalance);

        int zp = summaMeals / cooks.size();
        for (Person cook : cooks) {
           cook.getBankAccount().setBalance(zp + cook.getBankAccount().getBalance());
        }

    }
}
