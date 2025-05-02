package com.tvm.onboarding.Service;

import com.tvm.onboarding.Model.Education;
import com.tvm.onboarding.Repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EducationService {
    @Autowired
    private EducationRepository educationRepository;

    public ResponseEntity<Education> saveEducation(Education education){
        return   new ResponseEntity<>(educationRepository.save(education), HttpStatus.CREATED);
    }
}
