package com.tvm.onboarding.Repository;

import com.tvm.onboarding.Model.PreviousEmployment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreviousEmploymentRepository extends JpaRepository<PreviousEmployment,Integer> {

}
