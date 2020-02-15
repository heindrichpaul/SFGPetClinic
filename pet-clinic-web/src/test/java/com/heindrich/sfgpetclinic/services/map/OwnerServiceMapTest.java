package com.heindrich.sfgpetclinic.services.map;

import com.heindrich.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OwnerServiceMapTest {
    private final Long OWNER_ID = 1L;
    private final String LAST_NAME = "Doe";
    private OwnerServiceMap ownerServiceMap;


    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetServiceMap(), new PetTypeServiceMap());
        ownerServiceMap.save(Owner.builder().id(OWNER_ID).lastName(LAST_NAME).build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerServiceMap.findAll();
        assertEquals(1, owners.size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(OWNER_ID);
        Set<Owner> owners = ownerServiceMap.findAll();
        assertEquals(0, owners.size());
    }

    @Test
    void delete() {
        ownerServiceMap.deleteById(OWNER_ID);
        Set<Owner> owners = ownerServiceMap.findAll();
        assertEquals(0, owners.size());
    }

    @Test
    void save() {
        Long id = 2L;
        //If you use the object returned by the save test you aren't retrieving the object from the map.
        ownerServiceMap.save(Owner.builder().id(id).build());
        Owner savedOwner = ownerServiceMap.findById(id);
        assertEquals(id, savedOwner.getId());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(OWNER_ID);
        assertEquals(OWNER_ID, owner.getId());
    }

    @Test
    void findByLastName() {
        Owner owner = ownerServiceMap.findByLastName(LAST_NAME);
        assertEquals(LAST_NAME, owner.getLastName());
    }
}