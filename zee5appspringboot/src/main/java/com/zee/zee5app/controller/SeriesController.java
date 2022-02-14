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

import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.LocationNotFound;
import com.zee.zee5app.exception.NameNotFound;
import com.zee.zee5app.exception.RecordExists;
import com.zee.zee5app.payload.request.SeriesRequest;
import com.zee.zee5app.service.Series_Service1;

@RestController
@RequestMapping("/api/series")
public class SeriesController {
@Autowired
Series_Service1 series_Service1;
@PostMapping("/addSeries")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public ResponseEntity<?> addSeries(@Valid @RequestBody SeriesRequest seriesRequest) throws RecordExists

{
	Series series=new Series(seriesRequest.getName(),
			seriesRequest.getAgeLimit(),seriesRequest.getCast(),
			seriesRequest.getGenre(),seriesRequest.getTrailer(),
			Date.valueOf(seriesRequest.getReleaseDate()),seriesRequest.getLanguage(),seriesRequest.getNoEpisodes());
	Series seriesDetails=series_Service1.addSeries(series);
	return ResponseEntity.status(200).body(seriesDetails);
}
@GetMapping("/{id}")
@PreAuthorize("hasRole('ROLE_USER')")
public ResponseEntity<?> getAllDetails(@PathVariable("id") long id ) throws NameNotFound, LocationNotFound
{
	Optional<Series> seriesDetails=series_Service1.getSeriesdetails(id);
	return ResponseEntity.status(200).body(seriesDetails.get());
}
//{
//    "name":"Friends",
//    "ageLimit":13,
//    "cast":"A,B",
//    "genre":"A",
//    "trailer":"youtube.com/friends",
//    "releaseDate":"2022-02-13",
//    "language":"English",
//    "noEpisodes":10
//}
}
