package com.tvm.onboarding.Controller;

import com.tvm.onboarding.Model.Personal;
import com.tvm.onboarding.Model.Skills;
import com.tvm.onboarding.Service.PersonalService;
import com.tvm.onboarding.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("add")
    public ResponseEntity<ResponseStructure<Personal>> savePersonalInfo(@RequestBody Personal personal){
        return personalService.savePersonalInfo(personal);
    }

    @GetMapping("/searchByName/{name}")
    public ResponseEntity<ResponseStructure<Personal>> serachDetailsByName(@PathVariable String name){
        return personalService.findAllDetailsUsingName(name);
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
    @GetMapping
    public ResponseEntity<ResponseStructure<List<Personal>>> findAllSkills() {
        return personalService.findAllPersonal();
}


}
