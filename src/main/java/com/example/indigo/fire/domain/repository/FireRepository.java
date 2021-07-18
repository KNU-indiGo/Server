package com.example.indigo.fire.domain.repository;

import com.example.indigo.fire.domain.aggregate.Fire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FireRepository extends JpaRepository<Fire,Long> {
}
