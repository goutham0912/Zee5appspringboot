package com.zee.zee5app.repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Movies;
@Repository
public interface MovieRepository extends JpaRepository<Movies, Long> {
	Boolean existsByMovieName(String movieName);
	boolean existsById(Long id);
	//retrieve details findBy
	//And represents logical and
	
	Optional<Movies> findByMovieNameAndLanguage(String movieName,String language);
	
	//find moviedetails by movie name
	Optional<Movies> findByMovieName(String movieName);

	//find a movie based on title/moviename and rel date
	Optional<Movies> findByMovieNameAndReleaseDate(String movieName,Date releaseDate);

	//find a movie based on title/moviename and rel date
	Optional<List<Movies>> findByCast(String cast);


}
