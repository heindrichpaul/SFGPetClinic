package com.heindrich.sfgpetclinic.services.map;

import com.heindrich.sfgpetclinic.model.Owner;
import com.heindrich.sfgpetclinic.services.OwnerService;

import java.util.Set;

/**
 * Created by heindrichpaul on 11/02/2020
 */

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
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
    public Owner save(Owner owner) {
        return super.save(owner.getId(), owner);
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
