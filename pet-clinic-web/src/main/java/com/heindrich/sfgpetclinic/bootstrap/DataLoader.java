package com.heindrich.sfgpetclinic.bootstrap;

import com.heindrich.sfgpetclinic.model.*;
import com.heindrich.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * Created by heindrichpaul on 11/02/2020
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, PetService petService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0) {
            insertData();
        }
        CheckLoadedCount();

    }

    private void CheckLoadedCount() {
        System.out.println("=================================");
        System.out.println("Amount of PetTypes loaded: " + petTypeService.findAll().size());
        System.out.println("Amount of Pets loaded: " + petService.findAll().size());
        System.out.println("Amount of Owners loaded: " + ownerService.findAll().size());
        System.out.println("Amount of Specialties loaded: " + specialtyService.findAll().size());
        System.out.println("Amount of Vets loaded: " + vetService.findAll().size());
    }

    private void insertData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);
        System.out.println("Loaded PetTypes....");


        Owner owner1 = new Owner();
        owner1.setFirstName("Micheal");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami, FL");
        owner1.setTelephone("123123123123");

        Pet pet1 = new Pet();
        pet1.setPetType(savedDogPetType);
        pet1.setOwner(owner1);
        pet1.setBirthDate(LocalDate.now());
        pet1.setName("Rosco");
        System.out.println("Created Pet1");
        owner1.getPets().add(pet1);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("123 Brickerel");
        owner2.setCity("Miami, FL");
        owner2.setTelephone("1231231243534");

        Pet pet2 = new Pet();
        pet2.setPetType(savedCatPetType);
        pet2.setOwner(owner2);
        pet2.setBirthDate(LocalDate.now());
        pet2.setName("Kitty");
        System.out.println("Created Pet2");
        owner2.getPets().add(pet2);

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Speciality radiologySpeciality = new Speciality();
        radiologySpeciality.setDescription("Radiology");

        Speciality surgerySpeciality = new Speciality();
        surgerySpeciality.setDescription("Surgery");

        Speciality dentistrySpeciality = new Speciality();
        dentistrySpeciality.setDescription("Dentistry");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(radiologySpeciality);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(surgerySpeciality);
        vet2.getSpecialities().add(dentistrySpeciality);

        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}
