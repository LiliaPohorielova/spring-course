package ua.com.pogorelova.dao;

import org.springframework.stereotype.Component;
import ua.com.pogorelova.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component // Нужен бин только этого класса! Бин Person не нужен!
public class PersonDao {

    // В настоящем Dao - общение с БД, а не список
    private List<Person> people;
    private static int PEOPLE_COUNT = 0;

    // Блок инициализации (можно вместо этого конструктор)
    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Tom"));
        people.add(new Person(++PEOPLE_COUNT, "Jane"));
        people.add(new Person(++PEOPLE_COUNT, "Anna"));
        people.add(new Person(++PEOPLE_COUNT, "Rick"));
    }

    // create, update, delete

    public Person findById(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public List<Person> findAll() {
        return people;
    }
}
