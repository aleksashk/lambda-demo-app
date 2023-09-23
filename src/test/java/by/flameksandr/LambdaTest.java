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
}
