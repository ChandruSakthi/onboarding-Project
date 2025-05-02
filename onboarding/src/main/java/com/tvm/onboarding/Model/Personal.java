package com.tvm.onboarding.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Personal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fname;
    private String mname;
    private String lname;
    private String email;
    private String gender;
    private String bloodGroup;
    private String dob;
    private String merital;
    private String marriegedate;

    // Current Address Fields
    private String current_address;
    private String current_country;
    private String current_state;
    private String current_city;
    private Long current_pincode;

    // Permanent Address Fields
    private String permanent_address;
    private String permanent_country;
    private String permanent_state;
    private String permanent_city;
    private Long permanent_pincode;

    // BCP Address Fields
    private String bcp_address;
    private String bcp_country;
    private String bcp_state;
    private String bcp_city;
    private Long bcp_pincode;

    private Long current_contact;
    private Long permanent_contact;
    private String emergency_contact_name;
    private Long emergency_contact_number;
    private String emergency_relationship;
    private String year;
    private String month;
    private String relevantYear;


}

