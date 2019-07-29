package com.qa.controllers;

import com.qa.models.Customer;
import com.qa.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:8080")
public class HomeController {

    @Autowired
    private CustomerRepository repository;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String getHomePage(){
        return "Welcome to homepage";
    }

    @RequestMapping(value = "/addDefaultPeople", method = RequestMethod.GET)
    public void addDefaultPeople(){
        repository.save(new Customer("Alice", "Smith"));

        for (Customer customer : repository.findAll()) {
            System.out.println(customer);
        }
    }

}
