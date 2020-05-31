package com.rustudor.persistence.repository;

import com.rustudor.entity.Engine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EngineRepository extends JpaRepository<Engine,Integer> {
}
