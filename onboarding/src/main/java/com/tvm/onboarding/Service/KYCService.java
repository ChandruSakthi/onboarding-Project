package com.tvm.onboarding.Service;

import com.tvm.onboarding.Model.KYC;
import com.tvm.onboarding.Repository.KYCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class KYCService {
    @Autowired
    private KYCRepository kycRepository;

    public ResponseEntity<KYC> saveKyc(KYC kyc){
        return  new ResponseEntity<>(kycRepository.save(kyc), HttpStatus.CREATED);
    }
}
