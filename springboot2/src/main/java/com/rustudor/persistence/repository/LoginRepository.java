package com.rustudor.persistence.repository;

import com.rustudor.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotNull;
import java.util.List;


public interface LoginRepository extends JpaRepository<Login,Integer> {

    Login findByUsername(String username);
    List<Login> findAllByRoleEquals(@NotNull String role);
    Login findById(int id);

}
