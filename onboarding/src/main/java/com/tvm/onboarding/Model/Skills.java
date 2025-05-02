package com.tvm.onboarding.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private  String skillName ;
    private  String skillCategories;
    private  String versionNum;
    private  String experience_year ;
    private  String experience_month;
    private  String selfRate;

}
