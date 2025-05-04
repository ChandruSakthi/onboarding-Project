package com.tvm.onboarding.Service;

import com.tvm.onboarding.Exception.ResumeInValidException;
import com.tvm.onboarding.Model.Resume;
import com.tvm.onboarding.Model.Skills;
import com.tvm.onboarding.Repository.ResumeRepository;
import com.tvm.onboarding.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResumeService {
    @Autowired
    private ResumeRepository resumeRepository;

    public ResponseEntity<ResponseStructure<Resume>> saveResume(Resume resume){
        Resume saved=resumeRepository.save(resume);
        ResponseStructure<Resume>resumeDTO=new ResponseStructure<>();
        resumeDTO.setBody(saved);
        resumeDTO.setMessage("Resume Added Successfully...");
        resumeDTO.setStatusCode(HttpStatus.CREATED.value());
        return new ResponseEntity<>(resumeDTO,HttpStatus.CREATED);
    }
    public ResponseEntity<ResponseStructure<Resume>> getById(Integer id){
        Optional<Resume> dbResume =resumeRepository.findById(id);
        if (dbResume.isEmpty()){
            throw new ResumeInValidException("Resume ID Not Found:"+id);
        }
        ResponseStructure<Resume>resumeDTO=new ResponseStructure<>();
        resumeDTO.setBody(dbResume.get());
        resumeDTO.setMessage("Resume Fetch Successfully!!");
        resumeDTO.setStatusCode(HttpStatus.OK.value());
        return new ResponseEntity<>(resumeDTO,HttpStatus.OK);
    }
    public ResponseEntity<ResponseStructure<List<Resume>>> getAllResume(){
        List<Resume> resumes=resumeRepository.findAll();
        ResponseStructure<List<Resume>>resumeDto=new ResponseStructure<>();
        resumeDto.setBody(resumes);
        resumeDto.setMessage("List of Resumes");
        resumeDto.setStatusCode(HttpStatus.OK.value());
        return new ResponseEntity<>(resumeDto,HttpStatus.OK);
    }
    public ResponseEntity<ResponseStructure<Resume>> updateResume(Resume resume,Integer id){
        Optional<Resume> dbResume =resumeRepository.findById(id);
        if (dbResume.isEmpty()){
            throw new ResumeInValidException("Resume ID Not Found:"+id);
        }
        Resume resResume =dbResume.get();
        resResume.setAchievements(resume.getAchievements());
        resResume.setResumeCate(resume.getResumeCate());
        ResponseStructure<Resume>resumeDTO=new ResponseStructure<>();
        resumeDTO.setBody(resumeRepository.save(resResume));
        resumeDTO.setMessage("Resume Updated Successfully!!");
        resumeDTO.setStatusCode(HttpStatus.OK.value());
        return new ResponseEntity<>(resumeDTO,HttpStatus.OK);
    }
    public ResponseEntity<ResponseStructure<String>> deleteById(Integer id){
        Optional<Resume> dbResume =resumeRepository.findById(id);
        if (dbResume.isEmpty()){
            throw new ResumeInValidException("Resume ID Not Found:"+id);
        }
        resumeRepository.deleteById(id);
        ResponseStructure<String>resumeDTO=new ResponseStructure<>();
        resumeDTO.setBody("Resume Deleted Successfully!!!");
        resumeDTO.setMessage("Success");
        resumeDTO.setStatusCode(HttpStatus.OK.value());
        return new ResponseEntity<>(resumeDTO,HttpStatus.OK);
}

}
