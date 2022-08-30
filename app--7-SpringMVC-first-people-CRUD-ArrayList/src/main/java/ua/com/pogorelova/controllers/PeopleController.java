package ua.com.pogorelova.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import ua.com.pogorelova.dao.PersonDao;
import ua.com.pogorelova.models.Person;

import javax.validation.Valid;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDao personDao;

    public PeopleController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping("new")
    public String showCreatePage(Model model) {
        model.addAttribute("person", new Person());
        return "people/person_add";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "people/person_add";
        personDao.create(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String showEditPage(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDao.findById(id));
        return "people/person_edit";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable int id, @ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "people/person_edit";
        personDao.update(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        personDao.delete(id);
        return "redirect:/people";
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
