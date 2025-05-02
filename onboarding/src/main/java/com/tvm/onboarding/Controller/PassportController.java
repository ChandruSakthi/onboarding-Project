package com.tvm.onboarding.Controller;

import com.tvm.onboarding.Model.Passport;
import com.tvm.onboarding.Service.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("passport")
public class PassportController {

    @Autowired
    private PassportService passportService;

    @PostMapping("add")
    public ResponseEntity<Passport>  savePassport(@RequestBody Passport passport){
        return  passportService.savePassport(passport);
    }
}
