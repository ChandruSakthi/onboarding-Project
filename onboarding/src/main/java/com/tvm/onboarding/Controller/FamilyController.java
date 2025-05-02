package com.tvm.onboarding.Controller;

import com.tvm.onboarding.Model.Family;
import com.tvm.onboarding.Service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("family")
public class FamilyController {
    @Autowired
    private FamilyService familyService;

    @PostMapping("add")
    public ResponseEntity<Family> saveFamily(@RequestBody Family family){
        return  familyService.saveFamily(family);
    }
}
