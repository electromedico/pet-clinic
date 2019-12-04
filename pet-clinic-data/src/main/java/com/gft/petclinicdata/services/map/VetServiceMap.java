package com.gft.petclinicdata.services.map;

import com.gft.petclinicdata.model.Vet;
import com.gft.petclinicdata.model.VetSpecialty;
import com.gft.petclinicdata.services.VetService;
import com.gft.petclinicdata.services.VetSpecialtyService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet,Long> implements VetService {

    private final VetSpecialtyService vetSpecialtyService;

    public VetServiceMap(VetSpecialtyService vetSpecialtyService) {
        this.vetSpecialtyService = vetSpecialtyService;
    }


    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        object.getSpecialties().forEach(vetSpecialty -> {
            if (vetSpecialty.getId() == null){
                VetSpecialty newVetSpecialty = vetSpecialtyService.save(vetSpecialty);
                vetSpecialty.setId(newVetSpecialty.getId());
            }
        });
        return super.save(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
