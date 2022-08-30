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
        people.add(new Person(++PEOPLE_COUNT, "Tom", 24, "tom@email.com"));
        people.add(new Person(++PEOPLE_COUNT, "Jane", 40, "jane@email.com"));
        people.add(new Person(++PEOPLE_COUNT, "Anna", 15, "anna@email.com"));
        people.add(new Person(++PEOPLE_COUNT, "Rick", 18, "rick@email.com"));
    }

    // create, update, delete

    public void create(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person person) {
        Person personToBeUpdated = findById(id);
        personToBeUpdated.setName(person.getName());
        personToBeUpdated.setAge(person.getAge());
        personToBeUpdated.setEmail(person.getEmail());
    }

    public void delete(int id) {
        people.removeIf(person -> person.getId() == id);
    }

    public Person findById(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public List<Person> findAll() {
        return people;
    }
}
