package com.pozarycki.sfgpetclinic.services;

import com.pozarycki.sfgpetclinic.model.Owner;


public interface OwnerService extends CrudService<Owner, Long> {

   Owner findByLastName(String lastName);
}
