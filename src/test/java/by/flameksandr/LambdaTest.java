package by.flameksandr;

import by.flameksandr.objects.Person;
import by.flameksandr.services.DataService;
import org.junit.jupiter.api.Test;

import java.io.IOException;
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

        Runnable r1 = () -> {
            System.out.println("Running thread r1");
        };

        Runnable r2 = () -> {
            System.out.println("Running thread r2");
        };

        new Thread(r1).start();
        new Thread(r2).start();
    }
}
