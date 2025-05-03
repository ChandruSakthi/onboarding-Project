package com.tvm.onboarding.Repository;

import com.tvm.onboarding.Model.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillsRepository extends JpaRepository<Skills,Integer> {

}
