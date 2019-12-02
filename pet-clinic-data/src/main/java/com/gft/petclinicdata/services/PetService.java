package com.gft.petclinicdata.services;

import com.gft.petclinicdata.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findPetById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
