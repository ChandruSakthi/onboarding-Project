package com.tvm.onboarding.Controller;

import com.tvm.onboarding.Model.Admin;
import com.tvm.onboarding.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<String> RegisterAdmin(@RequestBody Admin admin) {
        return adminService.saveAdmin(admin);
    }

    @PostMapping("/login")
    public ResponseEntity<Optional<Admin>> VerifyAdmin(@RequestBody Admin admin) {
        return adminService.login(admin.getEmail(), admin.getPassword());
    }


}
