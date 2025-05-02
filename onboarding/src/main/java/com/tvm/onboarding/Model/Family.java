package com.tvm.onboarding.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Family {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fatherName;
    private String fatherDOB;
    private String motherName;
    private String motherDOB;
    private String spouseName;
    private String spouseDOB;
    private String spouseGender;
    private String children;


}
