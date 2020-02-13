package com.heindrich.sfgpetclinic.services.map;

import com.heindrich.sfgpetclinic.model.PetType;
import com.heindrich.sfgpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetTypeServiceMap extends AbstractMapService<PetType, Long> implements PetTypeService {

    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(PetType petType) {
        super.delete(petType);
    }

    @Override
    public PetType save(PetType petType) {
        super.save(petType);
        return petType;
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }
}
