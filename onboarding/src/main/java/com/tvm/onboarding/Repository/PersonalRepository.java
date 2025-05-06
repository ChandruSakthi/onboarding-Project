package com.tvm.onboarding.Repository;

import com.tvm.onboarding.Model.Personal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonalRepository extends JpaRepository<Personal,Integer> {

//    @Query("SELECT p FROM Personal p WHERE p.firstName = :name")
    List<Personal> findByFname(String name);

    List<Personal> findByPermanentCity(String city);

    Optional<Personal> findByPermanentContact(Long contact);
}
