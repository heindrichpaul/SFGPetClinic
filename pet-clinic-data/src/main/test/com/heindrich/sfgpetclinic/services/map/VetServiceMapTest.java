package com.heindrich.sfgpetclinic.services.map;

import com.heindrich.sfgpetclinic.model.Vet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VetServiceMapTest {

    private final Long VET_ID = 1L;
    private VetServiceMap vetServiceMap;

    @BeforeEach
    void setUp() {
        vetServiceMap = new VetServiceMap(new SpecialtyServiceMap());
        vetServiceMap.save(Vet.builder().id(VET_ID).build());
    }

    @Test
    void findAll() {
        Set<Vet> vets = vetServiceMap.findAll();
        assertEquals(1, vets.size());
    }

    @Test
    void deleteById() {
        vetServiceMap.deleteById(VET_ID);
        Set<Vet> vets = vetServiceMap.findAll();
        assertEquals(0, vets.size());
    }

    @Test
    void delete() {
        vetServiceMap.deleteById(VET_ID);
        Set<Vet> vets = vetServiceMap.findAll();
        assertEquals(0, vets.size());
    }

    @Test
    void save() {
        Long id = 2L;
        //If you use the object returned by the save test you aren't retrieving the object from the map.
        vetServiceMap.save(Vet.builder().id(id).build());
        Vet vet = vetServiceMap.findById(id);
        assertEquals(id, vet.getId());
    }

    @Test
    void findById() {
        Vet vet = vetServiceMap.findById(VET_ID);
        assertEquals(VET_ID, vet.getId());
    }
}