package com.tvm.onboarding.Service;

import com.tvm.onboarding.Model.Admin;
import com.tvm.onboarding.Model.Resume;
import com.tvm.onboarding.Repository.AdminRepository;
import com.tvm.onboarding.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin){
        ResponseStructure<Admin> structure=new ResponseStructure<>();
        structure.setMessage("Admin Addes Successfully..!!!");
        structure.setBody( adminRepository.save(admin));
        structure.setStatusCode(HttpStatus.CREATED.value());
        return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.CREATED);
    }
    public ResponseEntity<Optional<Admin>> login(String Email, String password){
        Optional<Admin> admin=adminRepository.findByEmailAndPassword(Email,password);
        return  new ResponseEntity<>(admin,HttpStatus.OK);
    }


}
