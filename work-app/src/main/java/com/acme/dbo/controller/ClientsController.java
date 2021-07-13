package com.acme.dbo.controller;

import com.acme.dbo.domain.Client;
import com.acme.dbo.service.ClientsService;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class ClientsController {
    private final ClientsService clientsService;

    public ClientsController(ClientsService clientsService) {
        this.clientsService = clientsService;
    }

    public void create(String name, String email) {
        clientsService.create(name, email);
    }

    public Client findById(String idData) {
        return clientsService.findById(Integer.valueOf(idData));
    }

    public Collection<Client> findAll() {
        return clientsService.findAll();
    }
}
