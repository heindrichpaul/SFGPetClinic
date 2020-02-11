package com.heindrich.sfgpetclinic.services.map;

import com.heindrich.sfgpetclinic.model.Pet;
import com.heindrich.sfgpetclinic.services.PetService;

import java.util.Set;

/**
 * Created by heindrichpaul on 11/02/2020
 */

public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet pet) {
        super.delete(pet);
    }

    @Override
    public Pet save(Pet pet) {
        return super.save(pet.getId(), pet);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
