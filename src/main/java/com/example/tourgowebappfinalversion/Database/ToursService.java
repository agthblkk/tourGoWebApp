package com.example.tourgowebappfinalversion.Database;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ToursService {
    private final ToursRepository ToursRepository;
    public ToursService(ToursRepository ToursRepository){
        this.ToursRepository = ToursRepository;
    }
    @Transactional
    public void addTour(String title, String date,
                          int availableSeatsNum) {

        Tours tour = new Tours(title, date, availableSeatsNum);
        try{
            ToursRepository.save(tour);
        }
        catch (NullPointerException e){
            System.out.println("OOOOOOPS");
        }
    }
    @Transactional(readOnly=true)
    public List<Tours> findAll(Pageable pageable) {
        return ToursRepository.findAll(pageable).getContent();
    }
    @Transactional(readOnly=true)
    public Tours findTour(long id) {
        return ToursRepository.findById(id).get();
    }
}
