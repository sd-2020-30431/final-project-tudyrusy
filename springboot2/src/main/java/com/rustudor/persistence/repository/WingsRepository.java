package com.rustudor.persistence.repository;

import com.rustudor.entity.Wings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WingsRepository extends JpaRepository<Wings,Integer> {
}
