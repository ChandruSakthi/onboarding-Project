package com.tvm.onboarding.Controller;

import com.tvm.onboarding.Model.Final;
import com.tvm.onboarding.Service.FinalService;
import com.tvm.onboarding.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("final")
public class FinalController {
    @Autowired
    private FinalService finalService;

    //    @PostMapping("add")
//    public ResponseEntity<Final> saveFinal(@RequestBody Final aFinal){
//        return  finalService.saveFinal(aFinal);
//    }
    @PostMapping
    public ResponseEntity<ResponseStructure<Final>> saveFinal(@RequestBody Final aFinal) {
        return finalService.saveFinal(aFinal);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseStructure<Final>> getById(@PathVariable Integer id) {
        return finalService.getById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseStructure<Final>> updateFinal(@PathVariable Integer id, @RequestBody Final aFinal) {
        return finalService.updateFinal(aFinal, id);
    }

    @GetMapping
    public ResponseEntity<ResponseStructure<List<Final>>> getAll() {
        return finalService.getFinalAll();
    }

    @DeleteMapping("/id")
    public ResponseEntity<ResponseStructure<String>> deleteFinal(@PathVariable Integer id) {
        return finalService.deleteFinal(id);
    }




}



