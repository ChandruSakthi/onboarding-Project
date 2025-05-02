package com.tvm.onboarding.Repository;

import com.tvm.onboarding.Model.KYC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KYCRepository extends JpaRepository<KYC,Integer> {
}
