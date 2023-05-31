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
                                 @RequestParam(value = "name", required = false) String name,
                                 @RequestParam(value = "surname", required = false) String surname,
                                 @RequestParam(value = "phone", required = false) String phone,
                                 @RequestParam(value = "email", required = false) String email,
                                 @RequestParam(value = "secondSelect", required = false) String tourId){
        // Create a new user
        Long idTour = Long.valueOf(tourId);
        Tours tour = toursService.findTour(idTour);
        Clients client = new Clients();
        client.setName(name);
        client.setSurname(surname);
        client.setPhone(phone);
        client.setEmail(email);
        client.setTour(tour);
        System.out.println(tourId);

        // Save the user to the database
        clientsRepository.save(client);
        return "redirect:/tookTourSuccessfully";

    }
}
