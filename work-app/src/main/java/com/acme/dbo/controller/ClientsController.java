package com.acme.dbo.controller;

import com.acme.dbo.domain.Client;
import com.acme.dbo.service.ClientsService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/client")
public class ClientsController {
    private final ClientsService clientsService;

    public ClientsController(ClientsService clientsService) {
        this.clientsService = clientsService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Client client) {
        clientsService.create(client);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void create1(@RequestParam String name, @RequestParam String email) {
        clientsService.create(name, email);
    }

    @GetMapping("/{id}")
    public Client findById(@PathVariable String id) {
        return clientsService.findById(Integer.valueOf(id));
    }

    @GetMapping
    public Collection<Client> findAll() {
        return clientsService.findAll();
    }
}
