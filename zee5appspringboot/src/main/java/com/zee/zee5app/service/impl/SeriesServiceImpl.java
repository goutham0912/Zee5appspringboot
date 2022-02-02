package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.NameNotFound;
import com.zee.zee5app.repository.SeriesRepository;
import com.zee.zee5app.service.Series_Service1;
@Service
public class SeriesServiceImpl implements Series_Service1 {
	@Autowired
 SeriesRepository repo;
	@Override
	public String addSeries(Series s) {
		// TODO Auto-generated method stub
		Series s1=repo.save(s);
		if(s1!=null)
			return "Success";
			else
				return "Failure";
	}

	@Override
	public String deleteSeries(String id) throws NameNotFound {
		// TODO Auto-generated method stub
		Optional<Series> optional=this.getSeriesdetails(id);
		if(optional.isEmpty())
			throw new NameNotFound("series not found");
		else
		{
			repo.deleteById(id);
			return "Successfully deleted";
		}
	}

	@Override
	public Optional<Series> getSeriesdetails(String id) throws NameNotFound {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public Optional<List<Series>> getallSeries() {
		// TODO Auto-generated method stub
		List<Series> m=repo.findAll();
		return Optional.ofNullable(m);
	}

	@Override
	public String updateseriesdetails(String id, Series s) throws NameNotFound {
		// TODO Auto-generated method stub
		return null;
	}

}
