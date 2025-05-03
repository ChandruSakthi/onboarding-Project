package com.tvm.onboarding.Controller;

import com.tvm.onboarding.Model.Resume;
import com.tvm.onboarding.Model.Skills;
import com.tvm.onboarding.Service.ResumeService;
import com.tvm.onboarding.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("resume")
public class ResumeController {
    @Autowired
    private ResumeService resumeService;

    @PostMapping("add")
    public ResponseEntity<ResponseStructure<Resume>> saveResume(@RequestBody Resume  resume){
        return  resumeService.saveResume(resume);
    }
    @GetMapping("{id}")
    public ResponseEntity<ResponseStructure<Resume>> getById(@PathVariable Integer id){
        return resumeService.getById(id);
    }
    @GetMapping
    public ResponseEntity<ResponseStructure<List<Resume>>> findAllResume(){
        return resumeService.getAllResume();
    }
    @PutMapping("{id}")
    public ResponseEntity<ResponseStructure<Resume>> updateById(@RequestBody Resume resume,@PathVariable Integer id){
        return resumeService.updateResume(resume,id);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<ResponseStructure<String>> deleteById(@PathVariable Integer id){
        return resumeService.deleteById(id);
}

}
