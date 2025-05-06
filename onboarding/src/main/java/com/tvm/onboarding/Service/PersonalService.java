package com.tvm.onboarding.Service;

import com.tvm.onboarding.Exception.PersonalNotFoundException;
import com.tvm.onboarding.Model.Personal;
import com.tvm.onboarding.Model.Resume;
import com.tvm.onboarding.Repository.PersonalRepository;
import com.tvm.onboarding.dto.ResponseStructure;
import org.aspectj.weaver.patterns.PerObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PersonalService {

    @Autowired
    private PersonalRepository personalRepository;

    // Save All Classes
    public ResponseEntity<ResponseStructure<Personal>> savePersonalInfo(Personal personal) {
        ResponseStructure<Personal> structure = new ResponseStructure<>();
        Personal savedPersonal = personalRepository.save(personal);

        structure.setMessage("Personal saved Successfully");
        structure.setBody(savedPersonal);
        structure.setStatusCode(HttpStatus.CREATED.value());

        return new ResponseEntity<>(structure, HttpStatus.CREATED);
    }

//Search Methods

    //Search all the Users By UserFirstName
    public ResponseEntity<ResponseStructure<List<Personal>>> findAllDetailsUsingName(String name) {
        ResponseStructure<List<Personal>> structure = new ResponseStructure<>();
        List<Personal> personals = personalRepository.findByFname(name);

        if (personals != null && !personals.isEmpty()) {
            structure.setMessage("Successfully found records with name: " + name);
            structure.setBody(personals);
            structure.setStatusCode(HttpStatus.OK.value());
            return new ResponseEntity<>(structure, HttpStatus.OK);
        } else {
            structure.setMessage("No records found with name: " + name);
            structure.setBody(Collections.emptyList());
            structure.setStatusCode(HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
        }
    }
    //Search all the Users By City Name
    public ResponseEntity<ResponseStructure<List<Personal>>> findAllDetailsUsingCity(String city) {
        ResponseStructure<List<Personal>> structure = new ResponseStructure<>();
        List<Personal> personals = personalRepository.findByPermanentCity(city);

        if (personals != null && !personals.isEmpty()) {
            structure.setMessage("Successfully found records with City: " + city);
            structure.setBody(personals);
            structure.setStatusCode(HttpStatus.OK.value());
            return new ResponseEntity<>(structure, HttpStatus.OK);
        } else {
            structure.setMessage("No records found with City: " + city);
            structure.setBody(Collections.emptyList());
            structure.setStatusCode(HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
        }
    }
    //Search all the Users By Contact No
    public ResponseEntity<ResponseStructure<Personal>> findAllDetailsUsingPhone(Long contact) {
        ResponseStructure<Personal> structure = new ResponseStructure<>();
        Optional<Personal> personals = personalRepository.findByPermanentContact(contact);

        if (personals.isEmpty()) {
//
            throw new PersonalNotFoundException("No User with th Contact No :"+contact);
        }
        structure.setMessage("Successfully found records with the Contact No: " + contact);
            structure.setBody(personals.get());
            structure.setStatusCode(HttpStatus.OK.value());
            return new ResponseEntity<>(structure, HttpStatus.OK);

    }



    //CRUD Methods

    // Find All Details using Id
    public ResponseEntity<ResponseStructure<Personal>> findById(Integer id) {
        ResponseStructure<Personal> structure = new ResponseStructure<>();

        Optional<Personal> dbPersonal = personalRepository.findById(id);
        if (dbPersonal.isEmpty()) {
            throw new PersonalNotFoundException("Personal Id not found :" + id);
        }

        structure.setMessage("Personal id Successfully found:" + id);
        structure.setBody(dbPersonal.get());
        structure.setStatusCode(HttpStatus.OK.value());
        return new ResponseEntity<>(structure, HttpStatus.OK);
    }
    // Update All The Class Fields

    public ResponseEntity<ResponseStructure<Personal>> updatePersonal(Personal personal, Integer id) {

        ResponseStructure<Personal> structure = new ResponseStructure<>();
        Optional<Personal> dbPersonal = personalRepository.findById(id);
        if (dbPersonal.isEmpty()) {
            throw new PersonalNotFoundException("Personal Id not Found :" + id);
        } else {
            Personal resPersonal = dbPersonal.get();
            resPersonal.setFname(personal.getFname());
            resPersonal.setLname(personal.getLname());
            resPersonal.setEmail(personal.getEmail());
            resPersonal.setGender(personal.getGender());
            resPersonal.setBloodGroup(personal.getBloodGroup());
            resPersonal.setCurrent_address(personal.getCurrent_address());
            resPersonal.setCurrent_city(personal.getCurrent_city());
            resPersonal.setCurrent_contact(personal.getCurrent_contact());
            resPersonal.setCurrent_state(personal.getCurrent_state());
            resPersonal.setCurrent_pincode(personal.getCurrent_pincode());
            resPersonal.setCurrent_country(personal.getCurrent_country());
            resPersonal.setPermanent_address(personal.getPermanent_address());
            resPersonal.setPermanent_state(personal.getPermanent_state());
            resPersonal.setPermanentCity(personal.getPermanentCity());
            resPersonal.setPermanent_pincode(personal.getPermanent_pincode());
            resPersonal.setPermanentContact(personal.getPermanentContact());
            resPersonal.setPermanent_country(personal.getPermanent_country());
            resPersonal.setBcp_address(personal.getBcp_address());
            resPersonal.setBcp_city(personal.getBcp_city());
            resPersonal.setBcp_country(personal.getBcp_country());
            resPersonal.setBcp_state(personal.getBcp_state());
            resPersonal.setBcp_pincode(personal.getBcp_pincode());
            resPersonal.setEmergency_contact_name(personal.getEmergency_contact_name());
            resPersonal.setEmergency_contact_number(personal.getEmergency_contact_number());
            resPersonal.setEmergency_relationship(personal.getEmergency_relationship());
            resPersonal.setYear(personal.getYear());
            resPersonal.setMonth(personal.getMonth());
            resPersonal.setRelevantYear(personal.getRelevantYear());

            Personal savedPersonal = personalRepository.save(resPersonal);
            structure.setMessage("Personal Details Updated Successfully With The Id:" + id);
            structure.setBody(savedPersonal);
            structure.setStatusCode(HttpStatus.ACCEPTED.value());

            return new ResponseEntity<>(structure, HttpStatus.CREATED);
        }
    }

    //Find All The User Details
    public ResponseEntity<ResponseStructure<List<Personal>>> findAllPersonal() {
        ResponseStructure<List<Personal>> structure = new ResponseStructure<>();

        List<Personal> personals = personalRepository.findAll();
        if (personals.isEmpty()) {
            throw new PersonalNotFoundException("Personal Details not Found");
        }
        structure.setMessage("List of all Personal details");
        structure.setBody(personals);
        structure.setStatusCode(HttpStatus.OK.value());

        return new ResponseEntity<>(structure, HttpStatus.OK);
    }

    // Delete The User Using Id
    public ResponseEntity<ResponseStructure<String>> deleteById(Integer id) {
        ResponseStructure<String> structure = new ResponseStructure<>();
        Optional<Personal> dbPersonal = personalRepository.findById(id);
        if (dbPersonal.isEmpty()) {
            throw new PersonalNotFoundException("Personal id not found:" + id);
        }
        personalRepository.deleteById(id);
        structure.setMessage("Personal Deleted With The Id : " + id);
        structure.setBody("Deleted with personal id");
        structure.setStatusCode(HttpStatus.OK.value());
        return new ResponseEntity<>(structure, HttpStatus.OK);
    }
    public Page<Personal> findAllAdmin(int offset, int pagesize){
        Page<Personal> page=personalRepository.findAll(PageRequest.of(offset,pagesize));
        return page;
}
}