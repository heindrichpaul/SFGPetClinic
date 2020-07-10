package com.heindrich.sfgpetclinic.services.springdatajpa;

import com.heindrich.sfgpetclinic.model.Owner;
import com.heindrich.sfgpetclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerServiceJpaTest {
    private final Long OWNER_ID = 1L;
    private final String LAST_NAME = "Doe";
    Owner OWNER;
    @Mock
    private OwnerRepository repository;
    @InjectMocks
    private OwnerJPAService service;

    @BeforeEach
    void setUp() {
        OWNER = Owner.builder().id(OWNER_ID).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        when(repository.findByLastName(any())).thenReturn(OWNER);

        Owner owner = service.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, owner.getLastName());

        verify(repository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>();
        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());

        when(repository.findAll()).thenReturn(owners);

        Set<Owner> o = service.findAll();
        assertNotNull(o);
        assertEquals(2, o.size());

        verify(repository).findAll();
    }

    @Test
    void findById() {

        when(repository.findById(any())).thenReturn(Optional.of(OWNER));

        Owner owner = service.findById(OWNER_ID);
        assertNotNull(owner);
        assertEquals(OWNER_ID, owner.getId());

        verify(repository).findById(any());
    }

    @Test
    void save() {

        when(repository.save(any())).thenReturn(OWNER);

        Owner owner = service.save(OWNER);
        assertNotNull(owner);
        assertEquals(OWNER_ID, owner.getId());

        verify(repository).save(any());
    }

    @Test
    void delete() {

        service.delete(OWNER);

        verify(repository).delete(any());
    }

    @Test
    void deleteById() {

        service.deleteById(OWNER_ID);

        verify(repository).deleteById(any());
    }
}