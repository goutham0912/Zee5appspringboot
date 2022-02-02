package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.exception.LocationNotFound;
import com.zee.zee5app.exception.NameNotFound;
import com.zee.zee5app.repository.EpisodeRepository;
import com.zee.zee5app.service.EpisodeService;
@Service
public class EpisodeServiceImpl implements EpisodeService {
	@Autowired
EpisodeRepository repo;
	@Override
	public String addepisode(Episodes m) {
		// TODO Auto-generated method stub
		Episodes episodes=repo.save(m);
		if(episodes!=null)
			return "Success";
		else
			return "Failed";
	}

	@Override
	public String deletepisode(String id) throws NameNotFound, LocationNotFound {
		// TODO Auto-generated method stub
		Optional<Episodes> optional=this.getEpisodesdetails(id);
		if(optional.isEmpty())
			throw new NameNotFound("Episode not found");
		else
		{
			repo.deleteById(id);
			return "Successfully deleted";
		}
	}

	@Override
	public Optional<Episodes> getEpisodesdetails(String id) throws NameNotFound, LocationNotFound {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public Optional<List<Episodes>> getallEpisodeDetails() {
		// TODO Auto-generated method stub
		List<Episodes> m=repo.findAll();
		return Optional.ofNullable(m);
		
	}

	@Override
	public Episodes update_episodedetails(String id, Episodes s) throws NameNotFound, LocationNotFound {
		// TODO Auto-generated method stub
		return null;
	}

}
