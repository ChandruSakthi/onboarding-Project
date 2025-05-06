package com.tvm.onboarding.Service;

import com.tvm.onboarding.Exception.EmployeeNotFoundException;
import com.tvm.onboarding.Model.Employee;
import com.tvm.onboarding.Repository.EmployeeRepository;
import com.tvm.onboarding.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository EmployeeRepository;

    @Autowired
    EmailService emailService;

    public ResponseEntity<ResponseStructure<Employee>> addUser(Employee user) {
        ResponseStructure<Employee> structure = new ResponseStructure<>();
//        emailService.sendRegistrationEmail(savedUser);
//        =usersRepository.save(user).setRole("User");
        structure.setMessage("User Registered Successfully!!");
        structure.setBody(EmployeeRepository.save(user));
        structure.setStatusCode(HttpStatus.CREATED.value());

        return new ResponseEntity<>(structure, HttpStatus.CREATED);
    }

    public ResponseEntity<ResponseStructure<Employee>> loginByEmail(String email, String password) {
        Employee user = EmployeeRepository.findByEmailAndPassword(email, password)
                .orElseThrow(() -> new EmployeeNotFoundException("Invalid email or password"));

        ResponseStructure<Employee> structure = new ResponseStructure<>();
        structure.setMessage("Login Successful");
        structure.setBody(user);
        structure.setStatusCode(HttpStatus.OK.value());

        return new ResponseEntity<>(structure, HttpStatus.OK);
    }
    public ResponseEntity<ResponseStructure<Employee>> loginByPhone(Long mobile, String password){
        ResponseStructure<Employee> structure=new ResponseStructure<>();
        Optional<Employee> users=EmployeeRepository.findByMobileAndPassword(mobile,password);
        if (users.isEmpty()){
            throw new EmployeeNotFoundException("Invalid Phone No Or Password..!!!");
        }
        structure.setMessage("User Login Success..!!!");
        structure.setBody(users.get());
        structure.setStatusCode(HttpStatus.OK.value());
        return  new ResponseEntity<ResponseStructure<Employee>>(structure,HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<String>> deleteById(Integer id) {
        ResponseStructure<String> structure = new ResponseStructure<>();

        Optional<Employee> dbUser = EmployeeRepository.findById(id);
        if (dbUser.isEmpty()) {
            throw new EmployeeNotFoundException("User id not found:" + id);
        }
        EmployeeRepository.deleteById(id);
        structure.setMessage("User Deleted With The Id : " + id);
        structure.setBody("User Deleted");
        structure.setStatusCode(HttpStatus.OK.value());
        return new ResponseEntity<>(structure, HttpStatus.OK);
}

}

