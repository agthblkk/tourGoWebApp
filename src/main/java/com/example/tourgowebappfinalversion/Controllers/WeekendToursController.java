package com.example.tourgowebappfinalversion.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WeekendToursController {
    @RequestMapping(value = "/weekend_tours", method = RequestMethod.GET)
    public String main(){
        return "wDaysTours";
    }
}
