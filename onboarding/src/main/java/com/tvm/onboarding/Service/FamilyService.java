package com.tvm.onboarding.Service;

import com.tvm.onboarding.Model.Family;
import com.tvm.onboarding.Repository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FamilyService {
    @Autowired
    private FamilyRepository familyRepository;

    public ResponseEntity<Family> saveFamily(Family family){
        return  new ResponseEntity<>(familyRepository.save(family), HttpStatus.CREATED);
    }
}
