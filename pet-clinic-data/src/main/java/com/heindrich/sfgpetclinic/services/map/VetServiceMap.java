package com.heindrich.sfgpetclinic.services.map;

import com.heindrich.sfgpetclinic.model.Speciality;
import com.heindrich.sfgpetclinic.model.Vet;
import com.heindrich.sfgpetclinic.services.SpecialtyService;
import com.heindrich.sfgpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by heindrichpaul on 11/02/2020
 */
@Service
@Profile({"default", "map"})
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public Vet save(Vet vet) {
        if (vet != null) {
            if (vet.getSpecialities() != null) {
                vet.getSpecialities().forEach(speciality -> {
                    if (speciality.getId() == null) {
                        Speciality saveSpecialty = specialtyService.save(speciality);
                        speciality.setId(saveSpecialty.getId());
                    }
                });
            }

            return super.save(vet);
        }
        return null;
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}

