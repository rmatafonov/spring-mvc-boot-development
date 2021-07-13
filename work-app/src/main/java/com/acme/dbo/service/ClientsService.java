package com.acme.dbo.service;

import com.acme.dbo.domain.Client;
import com.acme.dbo.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ClientsService {
    private final ClientRepository clientRepository;

    public ClientsService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client create(final Client client) {
        return clientRepository.create(client);
    }

    public Client create(final String name, final String email) {
        return clientRepository.create(new Client(0, name, email));
    }

    public Client findById(Integer id) {
        return clientRepository.findById(id);
    }

    public Collection<Client> findAll() {
        return clientRepository.findAll();
    }
}
