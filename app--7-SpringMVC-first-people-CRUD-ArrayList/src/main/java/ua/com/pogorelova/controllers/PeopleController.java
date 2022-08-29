package ua.com.pogorelova.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.com.pogorelova.dao.PersonDao;
import ua.com.pogorelova.models.Person;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDao personDao;

    public PeopleController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") int id, Model model) {
        // плохо (контроллер не должен за это отвечать)
        Person person = personDao.findById(id);
        if (person != null) {
            model.addAttribute("person", personDao.findById(id));
            return "people/person_details";
        } else {
            model.addAttribute("error", "Person with id = " + id + " does not exist!");
            return "error/error";
        }
    }

    @GetMapping()
    public String findAll(Model model) {
        model.addAttribute("people", personDao.findAll());
        return "people/person_all";
    }
}
