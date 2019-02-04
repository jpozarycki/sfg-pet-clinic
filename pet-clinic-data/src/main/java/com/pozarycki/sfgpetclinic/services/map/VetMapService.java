package com.pozarycki.sfgpetclinic.services.map;

import com.pozarycki.sfgpetclinic.model.Speciality;
import com.pozarycki.sfgpetclinic.model.Vet;
import com.pozarycki.sfgpetclinic.services.SpecialityService;
import com.pozarycki.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service

public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityService specialityService;

    public VetMapService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

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

        if (object.getSpecialities().size() > 0) {
            object.getSpecialities().forEach(speciality -> {
                if(speciality.getId() == null){
                    Speciality savedSpeciality = specialityService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }


}