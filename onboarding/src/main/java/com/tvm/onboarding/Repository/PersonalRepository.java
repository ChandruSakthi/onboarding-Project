package com.tvm.onboarding.Repository;

import com.tvm.onboarding.Model.Personal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalRepository extends JpaRepository<Personal,Integer> {

}
