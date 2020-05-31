package com.rustudor.persistence.repository;

import com.rustudor.entity.LandingGear;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LandingGearRepository extends JpaRepository<LandingGear,Integer> {
}
