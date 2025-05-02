package com.tvm.onboarding.Repository;

import com.tvm.onboarding.Model.Certification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificationRepository extends JpaRepository<Certification,Integer> {
}
