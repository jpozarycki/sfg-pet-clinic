package com.pozarycki.sfgpetclinic.services;

import com.pozarycki.sfgpetclinic.model.Owner;

import java.util.List;


public interface OwnerService extends CrudService<Owner, Long> {

   Owner findByLastName(String lastName);

   List<Owner> findAllByLastNameLike(String lastName);
}
