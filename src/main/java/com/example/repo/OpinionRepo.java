package com.example.repo;

import com.example.model.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpinionRepo extends JpaRepository<Opinion, Long> {
}
