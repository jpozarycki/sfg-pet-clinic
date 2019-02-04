package com.pozarycki.sfgpetclinic.bootstrap;

import com.pozarycki.sfgpetclinic.model.Owner;
import com.pozarycki.sfgpetclinic.model.Pet;
import com.pozarycki.sfgpetclinic.model.PetType;
import com.pozarycki.sfgpetclinic.model.Vet;
import com.pozarycki.sfgpetclinic.services.OwnerService;
import com.pozarycki.sfgpetclinic.services.PetTypeService;
import com.pozarycki.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

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

        vetService.save(vet1);

        Vet vet2 = new Vet();

        vet2.setFirstName("Konrad");
        vet2.setLastName("Zbyszkowski");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
