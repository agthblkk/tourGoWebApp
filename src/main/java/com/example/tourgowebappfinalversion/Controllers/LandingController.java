package com.example.tourgowebappfinalversion.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LandingController {
//    @RequestMapping(value = "/", method = RequestMethod.POST)
//    public String index(){
//        return "redirect:/main";
//    }
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(){
        return "index";
    }
}
