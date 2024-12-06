package com.backendproject.productservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/say")

// This is a sample controller class
public class SampleController {

    // This is a sample method
    @GetMapping("/hello/{name}/{times}")
    public String sayHello(@PathVariable("name") String name, @PathVariable("times") int times) {
        String output = "";

        for (int i = 0; i < times; i++) {
            output = output + " Hello " + name;
        }

        return output;
    }


    @GetMapping("/bye")
    public String sayBye() {
        return  "Bye Everyone!";
    }



}
