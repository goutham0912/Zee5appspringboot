package com.zee.zee5app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Episodes;
@Repository
public interface EpisodeRepository extends JpaRepository<Episodes, Long> {
Optional<Episodes> findById(Long id);
boolean existsByName(String name);
}
