package com.heindrich.sfgpetclinic.services.map;

import com.heindrich.sfgpetclinic.model.PetType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PetTypeServiceMapTest {
    private final Long PET_TYPE_ID = 1L;
    private PetTypeMapService petTypeServiceMap;

    @BeforeEach
    void setUp() {
        petTypeServiceMap = new PetTypeMapService();
        petTypeServiceMap.save(PetType.builder().id(PET_TYPE_ID).build());
    }

    @Test
    void findAll() {
        Set<PetType> petTypes = petTypeServiceMap.findAll();
        assertEquals(1, petTypes.size());
    }

    @Test
    void deleteById() {
        petTypeServiceMap.deleteById(PET_TYPE_ID);
        Set<PetType> petTypes = petTypeServiceMap.findAll();
        assertEquals(0, petTypes.size());
    }

    @Test
    void delete() {
        petTypeServiceMap.deleteById(PET_TYPE_ID);
        Set<PetType> petTypes = petTypeServiceMap.findAll();
        assertEquals(0, petTypes.size());
    }

    @Test
    void save() {
        Long id = 2L;
        //If you use the object returned by the save test you aren't retrieving the object from the map.
        petTypeServiceMap.save(PetType.builder().id(id).build());
        PetType petType = petTypeServiceMap.findById(id);
        assertEquals(id, petType.getId());
    }

    @Test
    void findById() {
        PetType petType = petTypeServiceMap.findById(PET_TYPE_ID);
        assertEquals(PET_TYPE_ID, petType.getId());
    }
}