package com.gft.petclinicdata.services;

import com.gft.petclinicdata.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findOwnerById(Long id);
    Owner findByLastName(String lastName);
    Owner save(Owner owner);
    Set<Owner> findAll();
}
