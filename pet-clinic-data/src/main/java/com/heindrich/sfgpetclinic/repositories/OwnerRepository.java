package com.heindrich.sfgpetclinic.repositories;

import com.heindrich.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
