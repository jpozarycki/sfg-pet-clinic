package com.pozarycki.sfgpetclinic.bootstrap;

import com.pozarycki.sfgpetclinic.model.*;
import com.pozarycki.sfgpetclinic.services.OwnerService;
import com.pozarycki.sfgpetclinic.services.PetTypeService;
import com.pozarycki.sfgpetclinic.services.SpecialityService;
import com.pozarycki.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0)
            loadData();
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();

        owner1.setFirstName("Michael");
        owner1.setLastName("Widmer");
        owner1.setAddress("1234 Kosciuszki");
        owner1.setCity("Stargard");
        owner1.setTelephone("123123123");

        Pet michaelsPet = new Pet();
        michaelsPet.setPetType(savedDogType);
        michaelsPet.setBirthDate(LocalDate.now());
        michaelsPet.setName("Stephan");
        owner1.getPets().add(michaelsPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();

        owner2.setFirstName("Jeff");
        owner2.setLastName("Bezos");
        owner2.setAddress("5678 Krzyowusttego");
        owner2.setCity("Szczecin");
        owner2.setTelephone("456456456");

        Pet jeffsCat = new Pet();
        jeffsCat.setPetType(savedCatType);
        jeffsCat.setBirthDate(LocalDate.now());
        jeffsCat.setName("Miaumiau");
        owner2.getPets().add(jeffsCat);

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();

        vet1.setFirstName("Jaroslaw");
        vet1.setLastName("Kaczynski");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();

        vet2.setFirstName("Konrad");
        vet2.setLastName("Zbyszkowski");
        vet2.getSpecialities().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
