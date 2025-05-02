package com.tvm.onboarding.Service;

import com.tvm.onboarding.Model.Passport;
import com.tvm.onboarding.Repository.PassportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PassportService {

    @Autowired
    private PassportRepository passportRepository;

    public ResponseEntity<Passport> savePassport(Passport passport){
        return new ResponseEntity<>(passportRepository.save(passport), HttpStatus.CREATED);
    }
}
