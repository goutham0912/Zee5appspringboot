package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.exception.LocationNotFound;
import com.zee.zee5app.exception.NameNotFound;
import com.zee.zee5app.exception.RecordExists;
import com.zee.zee5app.repository.MovieRepository;
import com.zee.zee5app.service.Movie_Service1;
@Service
public class MovieServiceImpl implements Movie_Service1 {
	@Autowired
	MovieRepository repo;
	@Override
	public Movies addMovie(Movies m) throws RecordExists {
		// TODO Auto-generated method stub
		if(repo.existsByMovieName(m.getMovieName()))
			throw new NullPointerException("Movie already exists");
		Movies movies= repo.save(m);
		if(movies!=null)
			return movies;
		else
			return null;
	}

	@Override
	public String deleteMovie(Long id) throws NameNotFound, LocationNotFound {
		// TODO Auto-generated method stub
		Optional<Movies> optional=this.getMoviedetails(id);
		if(optional.isEmpty())
			throw new NameNotFound("movie not found");
		else
		{
			repo.deleteById(id);
			return "Successfully deleted";
		}
	}

	@Override
	public Optional<Movies> getMoviedetails(Long id) throws NameNotFound, LocationNotFound {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public String[] getMovieCast(String moviename) throws NameNotFound, LocationNotFound {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<List<Movies>> getallMovies() {
		// TODO Auto-generated method stub
		List<Movies> m=repo.findAll();
		return Optional.ofNullable(m);
	}

	@Override
	public String updatemoviedetails(Long id, Movies s) throws NameNotFound, LocationNotFound {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String watchmovie(String moviename) throws LocationNotFound, NameNotFound {
		// TODO Auto-generated method stub
		return null;
	}

}
