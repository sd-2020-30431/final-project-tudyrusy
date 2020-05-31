package com.rustudor.persistence.repository;

import com.rustudor.entity.Plane;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaneRepository extends JpaRepository<Plane,Integer> {
    List<Plane> findAllByOkEqualsOrOkEquals(int ok, int ok2);
    Plane findById(int id);
}
