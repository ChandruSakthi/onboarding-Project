package com.tvm.onboarding.Service;

import com.tvm.onboarding.Model.Skills;
import com.tvm.onboarding.Repository.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SkillsService {
    @Autowired
    private SkillsRepository skillsRepository;

    public ResponseEntity<Skills> saveSkills(Skills skills){
        return new ResponseEntity<>(skillsRepository.save(skills), HttpStatus.CREATED);
    }
}
