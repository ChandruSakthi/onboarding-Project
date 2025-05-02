package com.tvm.onboarding.Controller;

import com.tvm.onboarding.Model.KYC;
import com.tvm.onboarding.Service.KYCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kyc")
public class KYCController {

    @Autowired
   private KYCService kycService;

    @PostMapping("add")
    public ResponseEntity<KYC> saveKYC(@RequestBody KYC kyc){
        return  kycService.saveKyc(kyc);
    }
}
