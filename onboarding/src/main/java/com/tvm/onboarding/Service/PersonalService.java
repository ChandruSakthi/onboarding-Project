package com.tvm.onboarding.Service;

import com.tvm.onboarding.Model.Personal;
import com.tvm.onboarding.Repository.PersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PersonalService {

    @Autowired
    private PersonalRepository personalRepository;

    public ResponseEntity<Personal> savePersonalInfo(Personal personal) {
        return new ResponseEntity<>(personalRepository.save(personal), HttpStatus.CREATED);

    }

    public ResponseEntity<Personal> findAllDetailsUsingName(String name) {
        return new ResponseEntity<>(personalRepository.findByFname(name), HttpStatus.OK);
    }


}

