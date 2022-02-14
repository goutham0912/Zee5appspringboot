package com.zee.zee5app.controller;

import java.sql.Date;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.exception.LocationNotFound;
import com.zee.zee5app.exception.NameNotFound;
import com.zee.zee5app.exception.RecordExists;
import com.zee.zee5app.payload.request.EpisodeRequest;
import com.zee.zee5app.payload.request.MovieRequest;
import com.zee.zee5app.repository.EpisodeRepository;
import com.zee.zee5app.repository.SeriesRepository;
import com.zee.zee5app.service.EpisodeService;

@RestController
@RequestMapping("/api/episodes")
public class EpisodeController {
	@Autowired
	EpisodeService episodeService;
	@Autowired
	EpisodeRepository episodeRepository;
	@Autowired
	SeriesRepository seriesRepository;
	@PostMapping("/addEpisodes")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> addMovie(@Valid @RequestBody EpisodeRequest episodeRequest) throws RecordExists
	{
		
		Episodes episodes=new Episodes(episodeRequest.getName(),episodeRequest.getLength(),episodeRequest.getLocation(), 
				episodeRequest.getTrailer(),
				seriesRepository.findById(episodeRequest.getSeries()).get());
		Episodes episodes2=episodeService.addepisode(episodes);
		
		
		return ResponseEntity.status(201).body(episodes2);
	}
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<?> getAllDetails(@PathVariable("id") long id ) throws NameNotFound, LocationNotFound
	{   	
		Optional<Episodes> seriesDetails=episodeService.getEpisodesdetails((id));
		return ResponseEntity.status(200).body(seriesDetails.get());
	}
}
