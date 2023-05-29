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
public class BookTourController {
    private final ToursRepository tourRepository;
    private final ToursService toursService;
    static final int DEFAULT_TOUR_ID = -1;
    private final ClientsRepository clientsRepository;

    public BookTourController(ToursRepository tourRepository, ToursService toursService,
                              ClientsRepository clientsRepository) {
        this.tourRepository = tourRepository;
        this.toursService = toursService;
        this.clientsRepository = clientsRepository;
    }
    @RequestMapping(value = "/taking_tour", method = RequestMethod.GET)
    public String viewPage(Model model) {
        List<Tours> tours = tourRepository.findAll();
        model.addAttribute("tours", tours);
        return "takeTour";
    }
    @RequestMapping("/tookTourSuccessfully")
    public String viewRegisterSuccessful(Model model) {
        return "afterTakeTour";
    }


    @RequestMapping(value = "/taking_tour", method = RequestMethod.POST)
    public String processBooking(Model model,
                                 @RequestParam(value = "name", required = true) String name,
                                 @RequestParam(value = "surname", required = true) String surname,
                                 @RequestParam(value = "phone", required = true) String phone,
                                 @RequestParam(value = "email", required = true) String email,
                                 @RequestParam(value = "tour", required = true) long tourId){
//        Clients client = new Clients();
//        client.setName(name);
//        client.setSurname(surname);
//        client.setPhone(phone);
//        client.setEmail(email);
        Tours tour = (tourId != DEFAULT_TOUR_ID) ? toursService.findTour(tourId) : null;
//        client.setTour(idTour);
//        Clients client = new Clients(name, surname, phone, email, tour);
        // Create a new user
        Clients client = new Clients();
        client.setName(name);
        client.setSurname(surname);
        client.setPhone(phone);
        client.setEmail(email);
        client.setTour(tour);

        // Save the user to the database
        clientsRepository.save(client);
        return "redirect:/tookTourSuccessfully";

    }
}
