package com.tvm.onboarding.Repository;

import com.tvm.onboarding.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    Optional<Employee> findByEmailAndPassword(String email, String password);
    Optional<Employee>findByMobileAndPassword(Long mobile, String password);
}
