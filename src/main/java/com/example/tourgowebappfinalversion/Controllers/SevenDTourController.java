package com.example.tourgowebappfinalversion.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SevenDTourController {
    @RequestMapping(value = "/seven_days_tour", method = RequestMethod.GET)
    public String main(){
        return "sevenDaysTours";
    }
}
