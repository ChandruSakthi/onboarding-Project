package com.tvm.onboarding.Service;

import com.tvm.onboarding.Model.Certification;
import com.tvm.onboarding.Repository.CertificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CertificationService {
    @Autowired
    private CertificationRepository certificationRepository;

    public ResponseEntity<Certification> saveCertification(Certification certification){
        return  new ResponseEntity<>(certificationRepository.save(certification), HttpStatus.CREATED);
    }
}
