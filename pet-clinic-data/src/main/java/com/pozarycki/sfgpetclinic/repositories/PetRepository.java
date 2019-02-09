package com.pozarycki.sfgpetclinic.repositories;

import com.pozarycki.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {
}
