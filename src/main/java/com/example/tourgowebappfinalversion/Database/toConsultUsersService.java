package com.example.tourgowebappfinalversion.Database;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class toConsultUsersService {
    private final toConsultUsersRepository toConsultUsersRepository;
    public toConsultUsersService(toConsultUsersRepository toConsultUsersRepository){
        this.toConsultUsersRepository = toConsultUsersRepository;
    }
    @Transactional
    public void addToConsultUsers(String format, String name, String surname,
                          String phone, String email) {

        toConsultUsers toConsultUser = new toConsultUsers(format, name, surname, phone, email);
        try{
            toConsultUsersRepository.save(toConsultUser);
        }
        catch (NullPointerException e){
            System.out.println("OOOOOOPS");
        }
    }
}
