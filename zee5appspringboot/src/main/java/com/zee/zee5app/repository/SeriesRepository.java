package com.zee.zee5app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Series;
@Repository
public interface SeriesRepository extends JpaRepository<Series, Long> {
 Optional<Series> findByNameAndLanguage(String name,String languauge);
 Optional<Series> findById(long Id);
 boolean existsByName(String name);
}
