package com.zee.zee5app.controller;

import java.math.BigDecimal;
//import java.util.Date;
import java.sql.Date;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.exception.LocationNotFound;
import com.zee.zee5app.exception.NameNotFound;
import com.zee.zee5app.exception.RecordExists;
import com.zee.zee5app.payload.request.MovieRequest;
import com.zee.zee5app.service.Movie_Service1;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
 @Autowired
 Movie_Service1 movie_Service1;
 
	@PostMapping("/addMovie")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> addMovie(@Valid @RequestBody MovieRequest movies ) throws RecordExists
	{
		
		Movies movies2=new Movies(movies.getMovieName()
				,movies.getAgeLimit(),movies.getCast(),
				movies.getGenre(),movies.getLength(),
						movies.getTrailer(),Date.valueOf(movies.getReleaseDate()),movies.getLanguage(),
								movies.getCategory());
		System.out.println(movies2+"------------");
		Movies movies1=movie_Service1.addMovie(movies2);
		
		
		return ResponseEntity.status(201).body(movies1);
	}
	@PostMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<?> getAllDetails(@PathVariable("id") long id ) throws NameNotFound, LocationNotFound
	{
		Optional<Movies> movieDetails=movie_Service1.getMoviedetails(id);
		return ResponseEntity.status(200).body(movieDetails.get());
	}
}	

