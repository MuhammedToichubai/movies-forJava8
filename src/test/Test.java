package test;


import test.service.imp.PersonImpl;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        PersonImpl service = new PersonImpl();

        for (Person per : creatingPerson()) {
            if (Status.CHEF.equals(per.getStatus())) {
                service.saveCooks(List.of(per));
            }
            else if (Status.CLIENT.equals(per.getStatus())){
                service.saveClient(List.of(per));
            }
        }
        System.out.println("Tamak zakaz bergenge cheyin");
        System.out.println(service.getAllClient());
        System.out.println(service.getAllCooks());

//
       service.pay(service.getAllClient().get(0),
               List.of(
                        Meal.meatball_soup,
                        Meal.spaghetti_bolognese,
                       Meal.pizza,
                       Meal.pizza
                        )
                );
//
        System.out.println("Akcha tologondon kyiyn");
        System.out.println(service.getAllClient());
        System.out.println(service.getAllCooks());
    }

    public static List<Person> creatingPerson(){
        return List.of(
             new Person(Status.CLIENT, "Mukhammed", new BankAccount(7000)),
             new Person(Status.CHEF, "Jidegul eje", new BankAccount(7000)),
             new Person(Status.CHEF, "Ilim", new BankAccount(7000))
        );
    }

}
