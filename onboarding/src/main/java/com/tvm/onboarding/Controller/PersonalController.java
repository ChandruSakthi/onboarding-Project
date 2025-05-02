package com.tvm.onboarding.Controller;

import com.tvm.onboarding.Model.Personal;
import com.tvm.onboarding.Service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("personal")
public class PersonalController {
    @Autowired
    private PersonalService personalService;

    @PostMapping("add")
    public ResponseEntity<Personal> savePersonalInfo(@RequestBody Personal personal){
        return personalService.savePersonalInfo(personal);
    }

}
