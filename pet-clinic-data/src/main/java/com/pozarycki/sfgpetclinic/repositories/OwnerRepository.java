package com.pozarycki.sfgpetclinic.repositories;

import com.pozarycki.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;


public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);
}
