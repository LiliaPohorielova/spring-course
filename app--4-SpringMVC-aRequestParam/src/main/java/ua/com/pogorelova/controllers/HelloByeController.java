package ua.com.pogorelova.controllers;

import org.springframework.stereotype.Controller;
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
    public String helloPage(HttpServletRequest request) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        System.out.println("Hello, " + name + " " + surname);
        return "hellobye/hello";
    }

    @GetMapping("/bye")
    public String byePage(@RequestParam(value = "name", required = false) String name,
                          @RequestParam(value = "surname", required = false) String surname) {
        System.out.println("Bye, " + name + " " + surname);
        return "hellobye/bye";
    }
}
