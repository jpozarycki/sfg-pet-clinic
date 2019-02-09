package com.pozarycki.sfgpetclinic.repositories;

import com.pozarycki.sfgpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VetRepository extends CrudRepository<Vet, Long> {
}
