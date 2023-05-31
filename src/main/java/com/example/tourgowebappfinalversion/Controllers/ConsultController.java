package com.example.tourgowebappfinalversion.Controllers;

import com.example.tourgowebappfinalversion.Database.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ConsultController {
    private final toConsultUserRepository toConsultUserRepository;

    public ConsultController(toConsultUserRepository toConsultUserRepository) {
        this.toConsultUserRepository = toConsultUserRepository;
    }
    @RequestMapping(value = "/taking_cons", method = RequestMethod.GET)
    public String viewPage(Model model) {
        return "takeCons";
    }
    @RequestMapping("/tookConsSuccessfully")
    public String viewRegisterSuccessful(Model model) {
        return "afterTakeCons";
    }


    @RequestMapping(value = "/taking_cons", method = RequestMethod.POST)
    public String procesBooking(Model model,
                                 @RequestParam(value = "name", required = false) String name,
                                 @RequestParam(value = "surname", required = false) String surname,
                                 @RequestParam(value = "phone", required = false) String phone,
                                 @RequestParam(value = "email", required = false) String email,
                                 @RequestParam(value = "formatSelect", required = false) String format){
        // Create a new user
        toConsultUser user = new toConsultUser();
        user.setName(name);
        user.setSurname(surname);
        user.setPhone(phone);
        user.setEmail(email);
        user.setFormat(format);

        // Save the user to the database
        toConsultUserRepository.save(user);
        return "redirect:/tookConsSuccessfully";

    }
}
