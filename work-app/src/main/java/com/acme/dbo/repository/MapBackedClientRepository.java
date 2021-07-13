package com.acme.dbo.repository;

import com.acme.dbo.domain.Client;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Repository
public class MapBackedClientRepository implements ClientRepository {
    private final Map<Integer, Client> clients = new HashMap<>(10);

    @Override
    public Client create(Client client) {
        final Client newClient = new Client(
                clients.isEmpty() ? 0 : Collections.max(clients.keySet()) + 1,
                client.getName(),
                client.getEmail()
        );
        clients.put(newClient.getId(), newClient);
        return newClient;
    }

    @Override
    public Client findById(Integer id) {
        return this.clients.get(id);
    }

    @Override
    public Collection<Client> findAll() {
        return clients.values();
    }
}
