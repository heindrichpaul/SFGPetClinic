package com.heindrich.sfgpetclinic.services;

import java.util.Set;

/**
 * Created by heindrichpaul on 11/02/2020
 */

public interface CrudService<T, ID> {

    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);
}
