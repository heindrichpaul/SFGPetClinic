package com.heindrich.sfgpetclinic.repositories;

import com.heindrich.sfgpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
