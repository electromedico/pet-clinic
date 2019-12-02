package com.gft.petclinicdata.services;

import com.gft.petclinicdata.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findVetById(Long id);
    Vet save(Vet vet);
    Set<Vet> findAll();
}
