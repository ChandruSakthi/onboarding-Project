package com.tvm.onboarding.Controller;

import com.tvm.onboarding.Model.Certification;
import com.tvm.onboarding.Service.CertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("certification")
public class CertificationController {
    @Autowired
    private CertificationService certificationService;

    @PostMapping("add")
    public ResponseEntity<Certification>  saveCertification(@RequestBody Certification certification){
        return  certificationService.saveCertification(certification);
    }
}
