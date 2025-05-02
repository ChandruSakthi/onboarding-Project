package com.tvm.onboarding.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class KYC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String pan;
    private  String panName;
    private String aadhar;
    private String aadharName;
    private String uan;
    private String pf;
    private String hdfc;

}
