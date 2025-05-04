package com.tvm.onboarding.Controller;

import com.tvm.onboarding.Model.Documents;
import com.tvm.onboarding.Service.DocumentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("documents")
public class DocumentsController {
    @Autowired
    private DocumentsService documentsService;

    @PostMapping
    public  String saveDocument(Documents documents){
        return  "This Is Documents...";
    }
}
