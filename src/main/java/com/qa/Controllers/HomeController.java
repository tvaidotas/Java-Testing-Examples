package com.qa.Controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:8080")
public class HomeController {

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String getHomePage(){
        return "Welcome to homepage";
    }

}
