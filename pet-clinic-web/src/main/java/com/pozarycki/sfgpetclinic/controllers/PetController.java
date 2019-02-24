package com.pozarycki.sfgpetclinic.controllers;

import com.pozarycki.sfgpetclinic.model.Owner;
import com.pozarycki.sfgpetclinic.model.PetType;
import com.pozarycki.sfgpetclinic.services.OwnerService;
import com.pozarycki.sfgpetclinic.services.PetService;
import com.pozarycki.sfgpetclinic.services.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.Optional;

@Controller
@RequestMapping("/owners/{ownersId}")
public class PetController {

    private static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdateForm";
    private final PetService petService;
    private final OwnerService ownerService;
    private final PetTypeService petTypeService;

    public PetController(PetService petService, OwnerService ownerService, PetTypeService petTypeService) {
        this.petService = petService;
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
    }

    @InitBinder
    public void initOwnerBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @ModelAttribute("types")
    public Collection<PetType> populatePetTypes() {
        return petTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable Long ownerId){
        Optional<Owner> ownerOptional = Optional.of(ownerService.findById(ownerId));
        if (ownerOptional.isPresent()){
            Owner ownerFound = ownerOptional.get();
            return ownerFound;
        } else {
            System.out.println("Owner not found");
            return null;
        }
    }

}
