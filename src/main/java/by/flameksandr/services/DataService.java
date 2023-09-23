package by.flameksandr.services;

import by.flameksandr.objects.Person;
import com.google.common.io.Resources;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class DataService {
    public static List<Person> getPeople() throws IOException {
        InputStream inputStream = Resources.getResource("people.json").openStream();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            StringBuilder jsonBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonBuilder.append(line);
            }

            Type listType = new TypeToken<List<Person>>() {
            }.getType();
            return new Gson().fromJson(jsonBuilder.toString(), listType);
        }
    }

    public static void printString() {
        System.out.println("Print our String.");
    }

    public static int compareId(Person p1, Person p2) {
        Integer id = p2.getId();
        return id.compareTo(p1.getId());
    }

    public int instanceMethodCompareId(Person p1, Person p2) {
        Integer id = p1.getId();
        return id.compareTo(p2.getId());
    }
}
