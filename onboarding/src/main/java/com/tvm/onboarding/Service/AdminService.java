package com.tvm.onboarding.Service;

import com.tvm.onboarding.Exception.AdminNotFoundException;
import com.tvm.onboarding.Model.Admin;
import com.tvm.onboarding.Repository.AdminRepository;
import com.tvm.onboarding.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
        Admin admin1=adminRepository.save(admin);
        admin1.setRole("user");
        structure.setBody( admin1);
        structure.setStatusCode(HttpStatus.CREATED.value());
        return new ResponseEntity<ResponseStructure<Admin>>(structure, HttpStatus.CREATED);
    }
    public ResponseEntity<ResponseStructure<Admin>> loginByEmail(String Email, String password){
        ResponseStructure<Admin> structure=new ResponseStructure<>();
        Optional<Admin> admin=adminRepository.findByEmailAndPassword(Email,password);
        if (admin.isEmpty()){
            throw new AdminNotFoundException("Invalid Email Or Password..!!!");
        }
        structure.setMessage("Admin Login Success..!!!");
        structure.setBody(admin.get());
        structure.setStatusCode(HttpStatus.OK.value());
        return  new ResponseEntity<>(structure,HttpStatus.OK);
    }
    public ResponseEntity<ResponseStructure<Admin>> loginByPhone(Long mobile, String password){
        ResponseStructure<Admin> structure=new ResponseStructure<>();
        Optional<Admin> admin=adminRepository.findByMobileAndPassword(mobile,password);
        if (admin.isEmpty()){
            throw new AdminNotFoundException("Invalid Phone No Or Password..!!!");
        }
        structure.setMessage("Admin Login Success..!!!");
        structure.setBody(admin.get());
        structure.setStatusCode(HttpStatus.OK.value());
        return  new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.OK);
    }
    public ResponseEntity<ResponseStructure<String>> deleteById(Integer id) {
        ResponseStructure<String> structure = new ResponseStructure<>();

        Optional<Admin> dbAdmin = adminRepository.findById(id);
        if (dbAdmin.isEmpty()) {
            throw new AdminNotFoundException("Admin id not found:" + id);
        }
        adminRepository.deleteById(id);
        structure.setMessage("Admin Deleted With The Id : " + id);
        structure.setBody("Admin Deleted");
        structure.setStatusCode(HttpStatus.OK.value());
        return new ResponseEntity<>(structure, HttpStatus.OK);
    }
    //Pagination
    public Page<Admin> findAllAdmin(int offset, int pagesize){
       Page<Admin> page=adminRepository.findAll(PageRequest.of(offset,pagesize));
        return page;
}

}
