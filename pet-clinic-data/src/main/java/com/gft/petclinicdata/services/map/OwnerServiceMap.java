package com.gft.petclinicdata.services.map;

import com.gft.petclinicdata.model.Owner;
import com.gft.petclinicdata.model.Pet;
import com.gft.petclinicdata.services.CrudService;
import com.gft.petclinicdata.services.OwnerService;
import com.gft.petclinicdata.services.PetService;
import com.gft.petclinicdata.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetService petService;
    private final PetTypeService petTypeService;

    public OwnerServiceMap(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {

        Owner newOwner = null;
        if (object != null){
            object.getPets().forEach(pet -> {
                if (pet != null){
                  if (pet.getPetType() != null ){
                      if (pet.getPetType().getId() == null){
                          pet.setPetType(petTypeService.save(pet.getPetType()));
                      }
                  } else {
                      throw new RuntimeException("Pet type is required");
                  }

                  if (pet.getId()== null){
                      Pet savedPet = petService.save(pet);
                      pet.setId(savedPet.getId());

                  }
                }
            });
            newOwner = super.save(object);
        }

        return newOwner;
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
