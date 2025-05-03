package com.tvm.onboarding.Controller;

import com.tvm.onboarding.Model.Personal;
import com.tvm.onboarding.Service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("personal")
public class PersonalController {
    @Autowired
    private PersonalService personalService;

    @PostMapping("add")
    public ResponseEntity<Personal> savePersonalInfo(@RequestBody Personal personal){
        return personalService.savePersonalInfo(personal);
    }

    @GetMapping("/searchByName/{name}")
    public ResponseEntity<Personal> serachDetailsByName(@PathVariable String name){
        return personalService.findAllDetailsUsingName(name);
    }

}
