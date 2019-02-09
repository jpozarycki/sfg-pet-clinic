package com.pozarycki.sfgpetclinic.repositories;

import com.pozarycki.sfgpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
