package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.exception.LocationNotFound;
import com.zee.zee5app.exception.NameNotFound;
import com.zee.zee5app.exception.RecordExists;

public interface Movie_Service1 {
	public Movies addMovie(Movies m) throws RecordExists;
	public String deleteMovie(Long id) throws NameNotFound, LocationNotFound;
	public Optional<Movies> getMoviedetails(Long id) throws NameNotFound, LocationNotFound;
	public String[] getMovieCast(String moviename) throws NameNotFound, LocationNotFound;
	public Optional<List<Movies>> getallMovies();
	public String updatemoviedetails(Long id,Movies s) throws NameNotFound, LocationNotFound;
	public String watchmovie(String moviename) throws LocationNotFound, NameNotFound;

}
