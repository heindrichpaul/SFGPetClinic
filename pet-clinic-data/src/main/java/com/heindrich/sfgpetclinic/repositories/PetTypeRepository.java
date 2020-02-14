package com.heindrich.sfgpetclinic.repositories;

import com.heindrich.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
