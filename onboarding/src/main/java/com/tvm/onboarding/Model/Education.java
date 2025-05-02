package com.tvm.onboarding.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String qualification;
    private String specilization;
    private String instituteName;
    private String universityName;
    private String time;
    private String fromDate;
    private String toDate;
    private String percentage;
    private String rollNo;
    private String educationType;

}
