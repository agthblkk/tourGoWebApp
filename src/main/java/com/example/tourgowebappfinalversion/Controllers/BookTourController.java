package com.example.tourgowebappfinalversion.Controllers;

import com.example.tourgowebappfinalversion.Database.Tours;
import com.example.tourgowebappfinalversion.Database.ToursRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class BookTourController {
    private final ToursRepository tourRepository;

    public BookTourController(ToursRepository tourRepository) {
        this.tourRepository = tourRepository;
    }
    @RequestMapping(value = "/taking_tour", method = RequestMethod.GET)
    public String viewPage(Model model){
        List<Tours> tours = tourRepository.findAll();
        model.addAttribute("tours", tours);
        return "takeTour";
    }


//    @RequestMapping(value = "/taking_tour", method = RequestMethod.POST)
//    public String processBooking(Model model,
//                                 @RequestParam(value = "name", required = true) String name,
//                                 @RequestParam(value = "name", required = true) String surname,
//                                 @RequestParam(value = "name", required = true) String phone,
//                                 @RequestParam(value = "name", required = true) String email,
//                                 @RequestParam(value = "tour", required = true) int tour){
//        Clients client = new Clients();
//        client.setName(name);
//        client.setSurname(surname);
//        client.setPhone(phone);
//        client.setEmail(email);
//        Tours
//        client.setTour(idTour);
//
//    }
}
