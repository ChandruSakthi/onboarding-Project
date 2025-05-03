package com.tvm.onboarding.Repository;

import com.tvm.onboarding.Model.Final;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinalRepository extends JpaRepository<Final,Integer> {
}
