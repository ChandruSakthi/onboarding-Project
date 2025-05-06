package com.tvm.onboarding.Controller;

import com.tvm.onboarding.Model.Admin;
import com.tvm.onboarding.Model.Personal;
import com.tvm.onboarding.Model.Skills;
import com.tvm.onboarding.Service.PersonalService;
import com.tvm.onboarding.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("personal")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonalController {
    @Autowired
    private PersonalService personalService;

    @PostMapping
    public ResponseEntity<ResponseStructure<Personal>> savePersonalInfo(@RequestBody Personal personal){
        return personalService.savePersonalInfo(personal);
    }

    @GetMapping("/searchByName/{name}")
    public ResponseEntity<ResponseStructure<List<Personal>>> serachDetailsByName(@PathVariable String name){
        return personalService.findAllDetailsUsingName(name);
    }
    @GetMapping("/searchByCity/{city}")
    public ResponseEntity<ResponseStructure<List<Personal>>> serachDetailsByCity(@PathVariable String city){
        return personalService.findAllDetailsUsingCity(city);
    }
    @GetMapping("/searchByContact/{contact}")
    public ResponseEntity<ResponseStructure<Personal>> serachDetailsByContact(@PathVariable Long contact){
        return personalService.findAllDetailsUsingPhone(contact);
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseStructure<Personal>> findById(@PathVariable Integer id) {
        return personalService.findById(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<ResponseStructure<Personal>> updateById(@RequestBody Personal personal, @PathVariable Integer id) {
        return personalService.updatePersonal(personal,id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ResponseStructure<String>> deleteById(@PathVariable Integer id) {
        return personalService.deleteById(id);
    }
    @GetMapping("/findAll")
    public ResponseEntity<ResponseStructure<List<Personal>>> findAllSkills() {
        return personalService.findAllPersonal();
}
//Pagination
    @GetMapping("pagination/{offset}/{pagesize}")
    public Page<Personal> pagination(@PathVariable int offset, @PathVariable int pagesize){
        return personalService.findAllAdmin(offset,pagesize);
    }


}
