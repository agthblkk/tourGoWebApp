package com.example.tourgowebappfinalversion.Database;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientsService {
    private final ClientsRepository clientsRepository;
    public ClientsService(ClientsRepository clientsRepository){
        this.clientsRepository = clientsRepository;
    }
    @Transactional
    public void addClient(String name, String surname,
                           String phone, String email, Tours tour) {

       Clients client = new Clients(name, surname, phone, email, tour);
        try{
            clientsRepository.save(client);
        }
        catch (NullPointerException e){
            System.out.println("OOOOOOPS");
        }
    }
}
