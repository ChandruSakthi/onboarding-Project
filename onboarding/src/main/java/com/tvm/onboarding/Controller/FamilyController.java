package com.tvm.onboarding.Controller;

import com.tvm.onboarding.Model.Family;
import com.tvm.onboarding.Service.FamilyService;
import com.tvm.onboarding.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("family")
public class FamilyController {
    @Autowired
    private FamilyService familyService;

    @PostMapping
    public ResponseEntity<ResponseStructure<Family>> saveFamily(@RequestBody Family family){
        return  familyService.saveFamily(family);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseStructure<Family>>getbyid(@PathVariable Integer id){
        return familyService.getbyid(id);
    }
    @GetMapping
    public ResponseEntity<ResponseStructure<List<Family>>>getall(){
        return familyService.getall();
    }
    @PutMapping("/{id}")
    public ResponseEntity<ResponseStructure<Family>>update(@PathVariable Integer id,@RequestBody Family family){
        return familyService.updateall(id,family);
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<ResponseStructure<String>> deletebyid(@PathVariable Integer id){
        return familyService.deletebyid(id);
}

}
