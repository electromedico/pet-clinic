package com.gft.petclinicdata.services.map;

import com.gft.petclinicdata.model.VetSpecialty;
import com.gft.petclinicdata.services.VetSpecialtyService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetSpecialtyMapService extends AbstractMapService<VetSpecialty, Long> implements VetSpecialtyService {
    @Override
    public Set<VetSpecialty> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(VetSpecialty object) {
        super.delete(object);
    }

    @Override
    public VetSpecialty save(VetSpecialty object) {
        return super.save(object);
    }

    @Override
    public VetSpecialty findById(Long id) {
        return super.findById(id);
    }
}
