package com.example.repo;

import com.example.model.Onion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OnionRepo extends JpaRepository<Onion, Long> {
}
