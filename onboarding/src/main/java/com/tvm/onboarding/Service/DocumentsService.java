package com.tvm.onboarding.Service;

import com.tvm.onboarding.Repository.DocumentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentsService {
    @Autowired
    private DocumentsRepository documentsRepository;
}
