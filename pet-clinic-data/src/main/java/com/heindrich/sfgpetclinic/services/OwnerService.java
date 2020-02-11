package com.heindrich.sfgpetclinic.services;

import com.heindrich.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
