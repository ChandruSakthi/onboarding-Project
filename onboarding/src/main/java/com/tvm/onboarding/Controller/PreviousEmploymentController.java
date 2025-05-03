package com.tvm.onboarding.Controller;

import com.tvm.onboarding.Model.PreviousEmployment;
import com.tvm.onboarding.Model.Resume;
import com.tvm.onboarding.Service.PreviousEmploymentService;
import com.tvm.onboarding.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("previousEmployment")
public class PreviousEmploymentController {
    @Autowired
    private PreviousEmploymentService previousEmploymentService;

    @PostMapping("add")
    public ResponseEntity<ResponseStructure<PreviousEmployment>> saveEmployment( @RequestBody PreviousEmployment previousEmployment){
        return  previousEmploymentService.saveEmployment(previousEmployment);
    }
    @GetMapping("{id}")
    public ResponseEntity<ResponseStructure<PreviousEmployment>> findById(@PathVariable Integer id){
        return previousEmploymentService.findById(id);
    }
    @PutMapping("{id}")
    public ResponseEntity<ResponseStructure<PreviousEmployment>> updateById(@RequestBody PreviousEmployment previousEmployment,@PathVariable Integer id){
        return previousEmploymentService.updateResume(previousEmployment,id);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<ResponseStructure<String>> deleteById(@PathVariable Integer id){
        return previousEmploymentService.deleteById(id);
    }
    @GetMapping
    public ResponseEntity<ResponseStructure<List<PreviousEmployment>>> findAllExperiences(){
        return previousEmploymentService.findAllResume();
    }
}
