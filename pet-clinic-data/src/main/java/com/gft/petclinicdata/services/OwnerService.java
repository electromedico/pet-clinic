package com.gft.petclinicdata.services;

import com.gft.petclinicdata.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
