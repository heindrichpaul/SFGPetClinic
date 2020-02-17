package com.heindrich.sfgpetclinic.services.map;

import com.heindrich.sfgpetclinic.model.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PetServiceMapTest {

    private final Long PET_ID = 1L;
    private PetServiceMap petServiceMap;

    @BeforeEach
    void setUp() {
        petServiceMap = new PetServiceMap();
        petServiceMap.save(Pet.builder().id(PET_ID).build());
    }

    @Test
    void findAll() {
        Set<Pet> pets = petServiceMap.findAll();
        assertEquals(1, pets.size());
    }

    @Test
    void deleteById() {
        petServiceMap.deleteById(PET_ID);
        Set<Pet> pets = petServiceMap.findAll();
        assertEquals(0, pets.size());
    }

    @Test
    void delete() {
        petServiceMap.deleteById(PET_ID);
        Set<Pet> pets = petServiceMap.findAll();
        assertEquals(0, pets.size());
    }

    @Test
    void save() {
        Long id = 2L;
        //If you use the object returned by the save test you aren't retrieving the object from the map.
        petServiceMap.save(Pet.builder().id(id).build());
        Pet savedPet = petServiceMap.findById(id);
        assertEquals(id, savedPet.getId());
    }

    @Test
    void findById() {
        Pet pet = petServiceMap.findById(PET_ID);
        assertEquals(PET_ID, pet.getId());
    }

}