package com.pozarycki.sfgpetclinic.services.map;

import com.pozarycki.sfgpetclinic.model.Vet;
import com.pozarycki.sfgpetclinic.services.VetService;

import java.util.Set;

public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

        @Override
        public Set<Vet> findAll() {
        return super.findAll();
    }

        @Override
        public void deleteById(Long id) {
        super.deleteById(id);
    }

        @Override
        public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(),object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }


}