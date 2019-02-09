package com.pozarycki.sfgpetclinic.repositories;

import com.pozarycki.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;


public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
