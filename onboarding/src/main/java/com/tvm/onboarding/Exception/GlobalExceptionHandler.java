package com.tvm.onboarding.Exception;

import com.tvm.onboarding.dto.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CertificationNotFoundException.class)
    public ResponseEntity<ResponseStructure<String>> handleUNFE(CertificationNotFoundException exception) {
        ResponseStructure<String> structure = new ResponseStructure<>();
        structure.setBody("ID Not Found");
        structure.setMessage(exception.getMessage());
        structure.setStatusCode(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(PersonalNotFoundException.class)
    public ResponseEntity<ResponseStructure<String>> handleUNFE(PersonalNotFoundException exception) {
        ResponseStructure<String> structure = new ResponseStructure<>();
        structure.setBody("ID Not Found");
        structure.setMessage(exception.getMessage());
        structure.setStatusCode(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EducationNotFoundException.class)
    public ResponseEntity<ResponseStructure<String>> handle(EducationNotFoundException exception) {
        ResponseStructure<String> structure = new ResponseStructure<>();
        structure.setBody("ID Not Found");
        structure.setMessage(exception.getMessage());
        structure.setStatusCode(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FamilyNotFoundException.class)
    public ResponseEntity<ResponseStructure<String>> handle(FamilyNotFoundException exception) {
        ResponseStructure<String> structure = new ResponseStructure<>();
        structure.setBody("ID not Found");
        structure.setBody(exception.getMessage());
        structure.setStatusCode(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResumeInValidException.class)
    public ResponseEntity<ResponseStructure<String>> handle(ResumeInValidException exception) {
        ResponseStructure<String> structure = new ResponseStructure<>();
        structure.setBody("Id Not Found");
        structure.setMessage(exception.getMessage());
        structure.setStatusCode(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PreviousEmploymentNotFoundException.class)
    public ResponseEntity<ResponseStructure<String>> handle(PreviousEmploymentNotFoundException exception) {
        ResponseStructure<String> structure = new ResponseStructure<>();
        structure.setBody("Id Not Found");
        structure.setMessage(exception.getMessage());
        structure.setStatusCode(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(SkillsNotFoundException.class)
    public ResponseEntity<ResponseStructure<String>> handle(SkillsNotFoundException exception) {
        ResponseStructure<String> structure = new ResponseStructure<>();
        structure.setBody("Id Not Found");
        structure.setMessage(exception.getMessage());
        structure.setStatusCode(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(FinalNotFoundException.class)
    public ResponseEntity<ResponseStructure<String>> handle(FinalNotFoundException exception) {
        ResponseStructure<String> structure = new ResponseStructure<>();
        structure.setBody("Id Not Found");
        structure.setMessage(exception.getMessage());
        structure.setStatusCode(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(PassportNotFoundException.class)
    public ResponseEntity<ResponseStructure<String>> handle(PassportNotFoundException exception) {
        ResponseStructure<String> structure = new ResponseStructure<>();
        structure.setBody("Id Not Found");
        structure.setMessage(exception.getMessage());
        structure.setStatusCode(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(KYCNotFoundException.class)
    public ResponseEntity<ResponseStructure<String>> handle(KYCNotFoundException exception) {
        ResponseStructure<String> structure = new ResponseStructure<>();
        structure.setBody("Id Not Found");
        structure.setMessage(exception.getMessage());
        structure.setStatusCode(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
    }

}
