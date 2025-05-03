package com.tvm.onboarding.Controller;

import com.tvm.onboarding.Model.Resume;
import com.tvm.onboarding.Service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("resume")
public class ResumeController {
    @Autowired
    private ResumeService resumeService;

    @PostMapping("add")
    public ResponseEntity<Resume> saveResume(@RequestBody Resume  resume){
        return  resumeService.saveResume(resume);
    }
}
