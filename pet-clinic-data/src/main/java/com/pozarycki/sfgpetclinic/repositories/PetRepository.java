package com.pozarycki.sfgpetclinic.repositories;

import com.pozarycki.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
