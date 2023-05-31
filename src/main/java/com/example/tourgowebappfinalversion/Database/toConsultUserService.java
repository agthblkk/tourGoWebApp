package com.example.tourgowebappfinalversion.Database;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class toConsultUserService {
    private final toConsultUserRepository toConsultUserRepository;
    public toConsultUserService(toConsultUserRepository toConsultUserRepository){
        this.toConsultUserRepository = toConsultUserRepository;
    }
    @Transactional
    public void addToConsultUsers(String format, String name, String surname,
                          String phone, String email) {

        toConsultUser toConsultUser = new toConsultUser(format, name, surname, phone, email);
        try{
            toConsultUserRepository.save(toConsultUser);
        }
        catch (NullPointerException e){
            System.out.println("OOOOOOPS");
        }
    }
}
