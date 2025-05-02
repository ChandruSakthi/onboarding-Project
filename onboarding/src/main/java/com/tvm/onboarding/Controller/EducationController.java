package com.tvm.onboarding.Controller;

import com.tvm.onboarding.Model.Education;
import com.tvm.onboarding.Service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("education")
public class EducationController {
    @Autowired
    private EducationService educationService;

    @PostMapping("add")
    public ResponseEntity<Education> saveEducation(@RequestBody Education education){
        return  educationService.saveEducation(education);
    }

}
