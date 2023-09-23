package by.flameksandr;

import by.flameksandr.interfaces.MultiArgInterface;
import by.flameksandr.interfaces.MyFunctionalInterface;
import by.flameksandr.objects.Person;
import by.flameksandr.services.DataService;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LambdaTest {
    @Test
    public void getPeople() throws IOException {
        List<Person> people = DataService.getPeople();
        assertEquals(people.size(), 1000);
    }

    @Test
    public void threadsLambdas() {
//        Runnable r1 = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Running thread r1;");
//            }
//        };
//        Runnable r2 = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Running thread r2;");
//            }
//        };
//
//        new Thread(r1).start();
//        new Thread(r2).start();

        //functional interface

        Runnable r1 = () -> System.out.println("Running thread r1");

        Runnable r2 = () -> System.out.println("Running thread r2");

        new Thread(r1).start();
        new Thread(r2).start();
    }

    @Test
    public void multiCommand() {
        Runnable r1 = () -> {
            System.out.println("Line 1");
            System.out.println("Line 2");
        };

        new Thread(r1).start();
    }

    @Test
    public void testInterface() {
        MyFunctionalInterface myFunctionalInterface = () -> System.out.println("Message from functional interface.");
        myFunctionalInterface.printMessage();
    }

    @Test
    public void multiArgInterface() {
        MultiArgInterface multiArgInterface = (m, n) -> {
            int sum = m + n;
            System.out.println("Sum: " + sum);
        };
        multiArgInterface.sum(10, -3);
    }


    @Test
    public void collectionsLamdbas() throws IOException {
        List<Person> people = DataService.getPeople();

        //sort
        people.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getLastName().compareToIgnoreCase(o2.getLastName());
            }
        });
        for (Person person : people) {
            System.out.println(person.getLastName());
        }
    }

    //sort with lambda

    Comparator<Person> comparator = (o1, o2) -> o2.getLastName().compareToIgnoreCase(o1.getLastName());

    @Test
    public void collectionsSortWithLambdas() throws IOException {
        List<Person> people = DataService.getPeople();

        people.sort(comparator);

        people.forEach(person -> System.out.println(person.getLastName()));
    }

    //predicate

//    @Test
//    public void testPredicate() throws IOException {
//        List<Person> people = DataService.getPeople();
//
//        Predicate<Person> predicate = new Predicate<Person>() {
//            @Override
//            public boolean test(Person person) {
//                return person.getGender().equalsIgnoreCase("Male");
//            }
//        };
//
//        for (Person person : people) {
//            if (predicate.test(person)) {
//                System.out.println(person.getLastName() + " Gender: " + person.getGender());
//            }
//        }
//    }

//    @Test
//    public Person testPredicateWithLambdas() throws IOException {
//        List<Person> people = DataService.getPeople();
//
//        Predicate<Person> predicate = person -> person.getGender()
//                .equalsIgnoreCase("Male");
//
//        people.forEach(person -> {
//            if (predicate.test(person)) {
//                System.out.println(person.getLastName() + " Gender: " + person.getGender());
//                return person;
//            }
//        });
//    }

    @Test
    public void testPredicateWithLambdas() throws IOException {
        List<Person> people = DataService.getPeople();

        Predicate<Person> predicate = person -> person.getGender()
                .equalsIgnoreCase("Male");

//        people.forEach(person -> {
//            if (predicate.test(person)) {
//                System.out.println(person.getLastName() + " Gender: " + person.getGender());
//            }
//        });

        people.forEach(System.out::println);
    }


    //reference method

    @Test
    public void referenceMethod() {
//        Thread thread = new Thread(() -> DataService.printString());

        Thread thread = new Thread(DataService::printString);
        thread.start();
    }
}
