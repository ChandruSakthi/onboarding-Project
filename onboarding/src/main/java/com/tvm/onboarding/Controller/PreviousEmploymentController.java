package com.tvm.onboarding.Controller;

import com.tvm.onboarding.Model.PreviousEmployment;
import com.tvm.onboarding.Service.PreviousEmploymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("previousEmployment")
public class PreviousEmploymentController {
    @Autowired
    private PreviousEmploymentService previousEmploymentService;

    @PostMapping("add")
    public ResponseEntity<PreviousEmployment> saveEmployment( @RequestBody PreviousEmployment previousEmployment){
        return  previousEmploymentService.saveEmployment(previousEmployment);
    }
}
