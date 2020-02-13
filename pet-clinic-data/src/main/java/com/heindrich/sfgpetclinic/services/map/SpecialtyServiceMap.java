package com.heindrich.sfgpetclinic.services.map;

import com.heindrich.sfgpetclinic.model.Speciality;
import com.heindrich.sfgpetclinic.services.SpecialtyService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SpecialtyServiceMap extends AbstractMapService<Speciality, Long> implements SpecialtyService {
    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Speciality object) {
        super.delete(object);
    }

    @Override
    public Speciality save(Speciality owner) {
        return super.save(owner);
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }
}
