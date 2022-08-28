package ua.com.pogorelova.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloByeController {

    @GetMapping("/")
    public String startPage() {
        return "hellobye/start";
    }

    @GetMapping("/hello")
    // http://localhost:8080/hello?name=Lilia&surname=Pogorelova
    public String helloPage(HttpServletRequest request, Model model) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        //System.out.println("Hello, " + name + " " + surname);
        if (name == null || surname == null)
            model.addAttribute("message", "Please, enter name and surname as parameters in a search line!");
        else model.addAttribute("message", "Hello, " + name + " " + surname);
        return "hellobye/hello";
    }

    @GetMapping("/bye")
    // http://localhost:8080/hello?name=Lilia&surname=Pogorelova
    public String byePage(@RequestParam(value = "name", required = false) String name,
                          @RequestParam(value = "surname", required = false) String surname,
                          Model model) {
        //System.out.println("Bye, " + name + " " + surname);
        if (name == null || surname == null)
            model.addAttribute("message", "Please, enter name and surname as parameters in a search line!");
        else model.addAttribute("message", "Bye, " + name + " " + surname);
        return "hellobye/bye";
    }
}
