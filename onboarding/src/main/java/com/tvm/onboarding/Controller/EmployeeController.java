package com.tvm.onboarding.Controller;

import com.tvm.onboarding.Model.Employee;
import com.tvm.onboarding.Service.EmployeeService;
import com.tvm.onboarding.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    EmployeeService EmployeeService;

    @PostMapping
    public ResponseEntity<ResponseStructure<Employee>> addUser(@RequestBody Employee employee){
        return EmployeeService.addUser(employee);
    }

    @PostMapping("/verifyByEmail")
    public ResponseEntity<ResponseStructure<Employee>> verifyByEmail(@RequestBody Employee employee){
        return EmployeeService.loginByEmail(employee.getEmail(), employee.getPassword());
    }

    @PostMapping ("/verifyByPhone")
    public ResponseEntity<ResponseStructure<Employee>> verifyByPhone(@RequestBody Employee employee) {
        return EmployeeService.loginByPhone(employee.getMobile(), employee.getPassword());

    }
    @DeleteMapping("{id}")
    public ResponseEntity<ResponseStructure<String>> deleteById(@PathVariable Integer id){
        return EmployeeService.deleteById(id);
}

}

