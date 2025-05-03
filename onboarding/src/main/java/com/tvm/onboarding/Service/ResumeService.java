package com.tvm.onboarding.Service;

import com.tvm.onboarding.Model.Resume;
import com.tvm.onboarding.Repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ResumeService {
    @Autowired
    private ResumeRepository resumeRepository;

    public ResponseEntity<Resume> saveResume(Resume resume){
        return  new ResponseEntity<>(resumeRepository.save(resume), HttpStatus.CREATED);
    }
}
