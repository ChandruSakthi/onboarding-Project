package com.tvm.onboarding.Controller;

import com.tvm.onboarding.Model.Final;
import com.tvm.onboarding.Service.FinalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("final")
public class FinalController {
    @Autowired
    private FinalService finalService;

    @PostMapping("add")
    public ResponseEntity<Final> saveFinal(@RequestBody Final aFinal){
        return  finalService.saveFinal(aFinal);
    }

}
