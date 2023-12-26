package com.example.tourgowebappfinalversion;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.example.tourgowebappfinalversion.Database.Tours;
import com.example.tourgowebappfinalversion.Database.ToursRepository;
import com.example.tourgowebappfinalversion.Database.ToursService;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;

class ToursServiceTest {

    private final ToursRepository toursRepository = mock(ToursRepository.class);

    private final ToursService toursService = new ToursService(toursRepository);

    @Test
    void testAddTour() {
        toursService.addTour("Tour Title", "2023-12-31", 10);

        verify(toursRepository).save(any());
    }
    public Page<Tours> PageImpl(List<Tours> expectedTours) {
        return (Page<Tours>) expectedTours;
    }

    @Test
    void testFindAll() {
        Pageable pageable = PageRequest.of(0, 10);
        List<Tours> expectedTours = Arrays.asList(new Tours(), new Tours());
        when(toursRepository.findAll(pageable)).thenReturn(PageImpl(expectedTours));

        List<Tours> result = toursService.findAll(pageable);

        assertEquals(expectedTours, result);
    }


    @Test
    void testFindTour() {
        Tours expectedTour = new Tours();
        when(toursRepository.findById(1L)).thenReturn(java.util.Optional.of(expectedTour));

        Tours result = toursService.findTour(1L);

        assertEquals(expectedTour, result);
    }

    // Add more tests as needed
}
