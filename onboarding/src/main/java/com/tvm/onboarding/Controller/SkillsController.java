package com.tvm.onboarding.Controller;

import com.tvm.onboarding.Model.Skills;
import com.tvm.onboarding.Service.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("skills")
public class SkillsController {
    @Autowired
    private SkillsService skillsService;

    @PostMapping("add")
    public ResponseEntity<Skills> saveSkills(@RequestBody Skills skills){
        return  skillsService.saveSkills(skills);
    }
}
