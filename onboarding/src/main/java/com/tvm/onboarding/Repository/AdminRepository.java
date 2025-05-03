package com.tvm.onboarding.Repository;

import com.tvm.onboarding.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {

    public Optional<Admin> findByEmailAndPassword(String email, String password);
}
