package com.heindrich.sfgpetclinic.services.map;

import com.heindrich.sfgpetclinic.model.Speciality;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpecialtyServiceMapTest {

    private final Long SPECIALTY_ID = 1L;
    private SpecialtyServiceMap specialtyServiceMap;

    @BeforeEach
    void setUp() {
        specialtyServiceMap = new SpecialtyServiceMap();
        specialtyServiceMap.save(Speciality.builder().id(SPECIALTY_ID).build());
    }

    @Test
    void findAll() {
        Set<Speciality> specialties = specialtyServiceMap.findAll();
        assertEquals(1, specialties.size());
    }

    @Test
    void deleteById() {
        specialtyServiceMap.deleteById(SPECIALTY_ID);
        Set<Speciality> specialities = specialtyServiceMap.findAll();
        assertEquals(0, specialities.size());
    }

    @Test
    void delete() {
        specialtyServiceMap.deleteById(SPECIALTY_ID);
        Set<Speciality> specialities = specialtyServiceMap.findAll();
        assertEquals(0, specialities.size());
    }

    @Test
    void save() {
        Long id = 2L;
        //If you use the object returned by the save test you aren't retrieving the object from the map.
        specialtyServiceMap.save(Speciality.builder().id(id).build());
        Speciality speciality = specialtyServiceMap.findById(id);
        assertEquals(id, speciality.getId());
    }

    @Test
    void findById() {
        Speciality speciality = specialtyServiceMap.findById(SPECIALTY_ID);
        assertEquals(SPECIALTY_ID, speciality.getId());
    }
}