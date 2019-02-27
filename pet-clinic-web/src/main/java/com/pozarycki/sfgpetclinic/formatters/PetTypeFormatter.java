package com.pozarycki.sfgpetclinic.formatters;

import com.pozarycki.sfgpetclinic.model.PetType;
import com.pozarycki.sfgpetclinic.services.PetTypeService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

@Controller
public class PetTypeFormatter implements Formatter<PetType> {

    private final PetTypeService petTypeService;

    public PetTypeFormatter(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public PetType parse(String text, Locale locale) throws ParseException {
        Collection<PetType> findPetTypes = petTypeService.findAll();
        for(PetType type : findPetTypes){
            if (type.getName().equals(text)){
                return type;
            }
        }
        throw new ParseException("Type not found: "+text,0);
    }

    @Override
    public String print(PetType object, Locale locale) {
        return object.getName();
    }
}