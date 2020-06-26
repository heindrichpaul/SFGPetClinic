package com.heindrich.sfgpetclinic.formatters;

import com.heindrich.sfgpetclinic.model.PetType;
import com.heindrich.sfgpetclinic.services.PetTypeService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;
import java.util.Optional;

@Component
public class PetTypeFormatter implements Formatter<PetType> {

    private final PetTypeService petTypeService;

    public PetTypeFormatter(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public String print(PetType petType, Locale locale) {
        return petType.getName();
    }

    @Override
    public PetType parse(String text, Locale locale) throws ParseException {
        Collection<PetType> findPetTypes = petTypeService.findAll();
        Optional<PetType> petTypeOptional = findPetTypes.stream()
                .filter(t -> t.getName().equals(text))
                .findFirst();
        for (PetType type : findPetTypes) {
            if (type.getName().equals(text)) {
                return type;
            }
        }
        if (petTypeOptional.isPresent()) {
            return petTypeOptional.get();
        }
        throw new ParseException("type not found: " + text, 0);
    }
}
