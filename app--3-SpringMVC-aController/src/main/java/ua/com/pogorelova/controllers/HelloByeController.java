package ua.com.pogorelova.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloByeController {

    @GetMapping("/hello")
    public String helloPage() {
        return "hellobye/hello";
    }

    @GetMapping("/bye")
    public String byePage() {
        return "hellobye/bye";
    }
}
