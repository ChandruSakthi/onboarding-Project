package com.tvm.onboarding.Service;

import com.tvm.onboarding.Exception.PassportNotFoundException;
import com.tvm.onboarding.Model.Passport;
import com.tvm.onboarding.Repository.PassportRepository;
import com.tvm.onboarding.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassportService {

    @Autowired
    private PassportRepository passportRepository;

    public ResponseEntity<ResponseStructure<Passport>> savePassport(Passport passport) {
        ResponseStructure<Passport> structure = new ResponseStructure<>();

        Passport savedPassport = passportRepository.save(passport);
        structure.setMessage("Passport saved successfully.");
        structure.setBody(savedPassport);
        structure.setStatusCode(HttpStatus.CREATED.value());

        return new ResponseEntity<>(structure, HttpStatus.CREATED);
    }

    public ResponseEntity<ResponseStructure<Passport>> getById(Integer id) {
        ResponseStructure<Passport> structure = new ResponseStructure<>();
        Optional<Passport> optionalPassport = passportRepository.findById(id);
        if (optionalPassport.isEmpty()) {
            throw new PassportNotFoundException("Passport not found with ID: " + id);
        }
        structure.setMessage("Passport found with ID: " + id);
        structure.setBody(optionalPassport.get());
        structure.setStatusCode(HttpStatus.FOUND.value());
        return new ResponseEntity<>(structure,HttpStatus.FOUND);
    }
    public ResponseEntity<ResponseStructure<List<Passport>>> getAll() {
        ResponseStructure<List<Passport>> structure = new ResponseStructure<>();

        List<Passport> passports = passportRepository.findAll();
        if (passports.isEmpty()){
            throw new PassportNotFoundException("Id is no records found");
        }
        structure.setMessage("List of all Passport records");
        structure.setBody(passports);
        structure.setStatusCode(HttpStatus.OK.value());

        return new ResponseEntity<>(structure, HttpStatus.OK);
    }


    public ResponseEntity<ResponseStructure<Passport>> updatePassport(Passport passport, Integer id) {
        ResponseStructure<Passport> structure = new ResponseStructure<>();

        Optional<Passport> optionalPassport = passportRepository.findById(id);
        if (optionalPassport.isEmpty()) {
            throw new PassportNotFoundException("Passport not found with ID: " + id);
        }
        else {
            Passport existingPassport = optionalPassport.get();
            existingPassport.setNationality(passport.getNationality());
            existingPassport.setIfPassport(passport.getIfPassport());
            existingPassport.setPassportNumber(passport.getPassportNumber());
            existingPassport.setNationality(passport.getNationality());
            existingPassport.setPersonal(passport.getPersonal());
            Passport passport1 = passportRepository.save(existingPassport);
            structure.setMessage("Passport successfully updated with ID "+id);
            structure.setBody(passport1);
            structure.setStatusCode(HttpStatus.ACCEPTED.value());

            return new ResponseEntity<>( structure, HttpStatus.OK);
        }
    }

    public ResponseEntity<ResponseStructure<String>> deletePassport(Integer id) {
        ResponseStructure<String> structure = new ResponseStructure<>();

        Optional<Passport> optionalPassport = passportRepository.findById(id);
        if (optionalPassport.isEmpty()) {
            throw new PassportNotFoundException("Passport Id not found : " + id);

        }
        passportRepository.deleteById(id);
        structure.setMessage("Passport successfully deleted with ID: " + id);
        structure.setBody("Deleted with Passport id");
        structure.setStatusCode(HttpStatus.OK.value());

        return new ResponseEntity<>(structure, HttpStatus.OK);
}




        }
