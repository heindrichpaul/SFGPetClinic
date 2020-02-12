package com.heindrich.sfgpetclinic.services.map;

import com.heindrich.sfgpetclinic.model.Vet;
import com.heindrich.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by heindrichpaul on 11/02/2020
 */
@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet owner) {
        return super.save(owner);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
