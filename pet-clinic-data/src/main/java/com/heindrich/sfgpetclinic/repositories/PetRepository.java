package com.heindrich.sfgpetclinic.repositories;

import com.heindrich.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
