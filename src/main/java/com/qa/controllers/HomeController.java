package com.qa.controllers;

import com.qa.models.Customer;
import com.qa.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:8080")
public class HomeController {

    @Autowired
    private CustomerRepository repository;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String getHomePage(){
        return "Welcome to homepage";
    }

    @RequestMapping(value = "/addDefaultCustomers", method = RequestMethod.GET)
    public void addDefaultPeople(){
        repository.save(new Customer("Alice", "Smith"));
        repository.save(new Customer("John", "Johnson"));
        repository.save(new Customer("Tim", "White"));
    }

    @RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
    public void saveCustomer(@RequestBody Customer customer){
        repository.save(customer);
    }

}
