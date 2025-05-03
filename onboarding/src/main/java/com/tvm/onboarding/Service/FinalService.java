package com.tvm.onboarding.Service;

import com.tvm.onboarding.Model.Final;
import com.tvm.onboarding.Repository.FinalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FinalService {
    @Autowired
    private FinalRepository finalRepository;

    public ResponseEntity<Final> saveFinal(Final aFinal) {
        return new ResponseEntity<>(finalRepository.save(aFinal), HttpStatus.CREATED);
    }
}
