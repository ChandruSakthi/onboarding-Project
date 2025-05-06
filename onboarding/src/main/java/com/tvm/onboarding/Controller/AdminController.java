package com.tvm.onboarding.Controller;

import com.tvm.onboarding.Model.Admin;
import com.tvm.onboarding.Service.AdminService;
import com.tvm.onboarding.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping
    public ResponseEntity<ResponseStructure<Admin>> RegisterAdmin(@RequestBody Admin admin) {
        return adminService.saveAdmin(admin);
    }

    @PostMapping ("/verifyByEmail")
    public ResponseEntity<ResponseStructure<Admin>> VerifyByEmail(@RequestBody Admin admin) {
        return adminService.loginByEmail(admin.getEmail(), admin.getPassword());
    }
    @PostMapping ("/verifyByMobile")
    public ResponseEntity<ResponseStructure<Admin>> VerifyByPhone(@RequestBody Admin admin) {
        return adminService.loginByPhone(admin.getMobile(), admin.getPassword());
    }
    @DeleteMapping("{id}")
    public ResponseEntity<ResponseStructure<String>> deleteById(@PathVariable Integer id){
        return adminService.deleteById(id);
    }



}
