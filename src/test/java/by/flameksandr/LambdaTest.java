package by.flameksandr;

import by.flameksandr.interfaces.MultiArgInterface;
import by.flameksandr.interfaces.MyFunctionalInterface;
import by.flameksandr.objects.Person;
import by.flameksandr.services.DataService;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

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

        people.forEach(o -> System.out.println(o.getLastName()));
    }
}
