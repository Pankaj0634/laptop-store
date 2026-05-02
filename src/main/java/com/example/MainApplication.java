package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}

@Controller
class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        List<Laptop> laptops = List.of(
                new Laptop("Dell XPS 13", 900),
                new Laptop("HP Pavilion", 700),
                new Laptop("MacBook Air M2", 1200)
        );

        model.addAttribute("laptops", laptops);
        return "index";
    }
}

class Laptop {
    private String name;
    private int price;

    public Laptop(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public int getPrice() { return price; }
}