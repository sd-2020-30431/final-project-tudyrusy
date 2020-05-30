package com.rustudor.persistence.repository;

import com.rustudor.entity.Plane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaneRepository extends JpaRepository<Plane,Integer> {
}
