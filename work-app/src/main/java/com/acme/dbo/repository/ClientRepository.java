package com.acme.dbo.repository;

import com.acme.dbo.domain.Client;

import java.util.Collection;

public interface ClientRepository {
    Client create(Client client);

    Client findById(Integer id);

    Collection<Client> findAll();
}
