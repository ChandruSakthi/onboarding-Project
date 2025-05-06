package com.tvm.onboarding.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Documents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "personal_id")
    @JsonBackReference
    private Personal personal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }
}
//{
//    "panCard": "C:\\fakepath\\logo.png",
//    "aadharCard": "C:\\fakepath\\logo.png",
//    "pSizePhoto": "C:\\fakepath\\logo.png",
//    "intermediate": "C:\\fakepath\\logo.png",
//    "graduationMarksheet": "C:\\fakepath\\logo.png",
//    "postGraduation": "C:\\fakepath\\logo.png",
//    "latestPhoto": "C:\\fakepath\\logo.png",
//    "empDocument": "C:\\fakepath\\logo.png"
//}
