package com.heindrich.sfgpetclinic.services.map;

import com.heindrich.sfgpetclinic.model.Visit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VisitServiceMapTest {

    private final Long VISIT_ID = 1L;
    private VisitServiceMap visitServiceMap;

    @BeforeEach
    void setUp() {
        visitServiceMap = new VisitServiceMap();
        visitServiceMap.save(Visit.builder().id(VISIT_ID).build());
    }

    @Test
    void findAll() {
        Set<Visit> visits = visitServiceMap.findAll();
        assertEquals(1, visits.size());
    }

    @Test
    void deleteById() {
        visitServiceMap.deleteById(VISIT_ID);
        Set<Visit> visits = visitServiceMap.findAll();
        assertEquals(0, visits.size());
    }

    @Test
    void delete() {
        visitServiceMap.deleteById(VISIT_ID);
        Set<Visit> visits = visitServiceMap.findAll();
        assertEquals(0, visits.size());
    }

    @Test
    void save() {
        Long id = 2L;
        //If you use the object returned by the save test you aren't retrieving the object from the map.
        visitServiceMap.save(Visit.builder().id(id).build());
        Visit visit = visitServiceMap.findById(id);
        assertEquals(id, visit.getId());
    }

    @Test
    void findById() {
        Visit visit = visitServiceMap.findById(VISIT_ID);
        assertEquals(VISIT_ID, visit.getId());
    }
}