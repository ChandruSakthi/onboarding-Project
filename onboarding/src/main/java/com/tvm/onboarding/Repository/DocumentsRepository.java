package com.tvm.onboarding.Repository;

import com.tvm.onboarding.Model.Documents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentsRepository extends JpaRepository<Documents,Integer> {
}
