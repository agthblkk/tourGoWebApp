package com.example.tourgowebappfinalversion;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.example.tourgowebappfinalversion.Controllers.BookTourController;
import com.example.tourgowebappfinalversion.Database.Clients;
import com.example.tourgowebappfinalversion.Database.ClientsRepository;
import com.example.tourgowebappfinalversion.Database.Tours;
import com.example.tourgowebappfinalversion.Database.ToursRepository;
import com.example.tourgowebappfinalversion.Database.ToursService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

class BookTourControllerTest {

    @InjectMocks
    private BookTourController bookTourController;

    @Mock
    private ToursRepository toursRepository;

    @Mock
    private ToursService toursService;

    @Mock
    private ClientsRepository clientsRepository;

    @Test
    void testViewPage() {
        Model model = mock(Model.class);
        List<Tours> tours = new ArrayList<>();
        when(toursRepository.findAll()).thenReturn(tours);

        String result = bookTourController.viewPage(model);

        assertEquals("takeTour", result);
        verify(model).addAttribute("tours", tours);
    }

    @Test
    void testProcessBooking() {
        Model model = mock(Model.class);
        when(clientsRepository.save(any())).thenReturn(new Clients());

        String result = bookTourController.processBooking(model, "John", "Doe", "123456789", "john.doe@example.com", "1");

        assertEquals("redirect:/tookTourSuccessfully", result);
        verify(clientsRepository).save(any());
    }

    // Add more tests as needed
}

