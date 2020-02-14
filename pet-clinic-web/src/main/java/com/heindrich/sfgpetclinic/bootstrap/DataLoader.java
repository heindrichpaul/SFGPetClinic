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
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      PetService petService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
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
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialtyService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialtyService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedDentistry = specialtyService.save(dentistry);

        Owner owner1 = Owner.builder()
                .firstName("Michael")
                .lastName("Weston")
                .address("123 Brickerel")
                .city("Miami")
                .telephone("1231231234")
                .build();

        Pet mikesPet = Pet.builder()
                .petType(savedDogPetType)
                .owner(owner1)
                .birthDate(LocalDate.now())
                .name("Rosco")
                .build();

        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = Owner.builder()
                .firstName("Fiona")
                .lastName("Glenanne")
                .address("123 Brickerel")
                .city("Miami")
                .telephone("1231231234")
                .build();

        Pet fionasCat = Pet.builder()
                .petType(savedCatPetType)
                .owner(owner2)
                .birthDate(LocalDate.now())
                .name("Just Cat")
                .build();

        owner2.getPets().add(fionasCat);

        ownerService.save(owner2);

        Visit catVisit = Visit.builder()
                .pet(fionasCat)
                .date(LocalDate.now())
                .description("Sneezy Kitty")
                .build();

        visitService.save(catVisit);

        System.out.println("Loaded Owners....");

        Vet vet1 = Vet.builder()
                .firstName("Sam")
                .lastName("Axe")
                .build();
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = Vet.builder()
                .firstName("Jessie")
                .lastName("Porter")
                .build();
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}
