package com.tvm.onboarding.Service;

import com.tvm.onboarding.Model.PreviousEmployment;
import com.tvm.onboarding.Repository.PreviousEmploymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PreviousEmploymentService {
    @Autowired
    private PreviousEmploymentRepository previousEmploymentRepository;

    public ResponseEntity<PreviousEmployment> saveEmployment(PreviousEmployment previousEmployment) {
        return new ResponseEntity<>(previousEmploymentRepository.save(previousEmployment), HttpStatus.CREATED);
    }
}
