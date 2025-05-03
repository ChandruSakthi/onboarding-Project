package com.tvm.onboarding.Controller;

import com.tvm.onboarding.Model.Education;
import com.tvm.onboarding.Service.EducationService;
import com.tvm.onboarding.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("education")
public class EducationController {
    @Autowired
    private EducationService educationService;

    @PostMapping
    public ResponseEntity<ResponseStructure<Education>> saveEducation(@RequestBody Education education) {
        return educationService.saveEducation(education);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseStructure<Education>> getbyid(@PathVariable Integer id) {
        return educationService.getbyid(id);
    }

    @GetMapping
    public ResponseEntity<ResponseStructure<List<Education>>> getall() {
        return educationService.getall();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseStructure<Education>> updatebyid(@PathVariable Integer id, @RequestBody Education education) {
        return educationService.updatebyid(id, education);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseStructure<String>> deleteByid(@PathVariable Integer id) {
        return educationService.deletebyid(id);
    }


}
