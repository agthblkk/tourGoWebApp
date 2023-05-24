package com.example.tourgowebappfinalversion.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ToursController {
    @RequestMapping(value = "/tours", method = RequestMethod.GET)
    public String main(){
        return "tours";
    }
}
