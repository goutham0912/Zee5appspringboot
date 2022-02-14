package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.NameNotFound;
import com.zee.zee5app.exception.RecordExists;

public interface Series_Service1 {
	public Series addSeries(Series s) throws RecordExists;
	public String deleteSeries(Long id) throws NameNotFound;
	public Optional<Series> getSeriesdetails(Long id) throws NameNotFound;
	public Optional<List<Series>> getallSeries();
	public String updateseriesdetails(Long id,Series s) throws NameNotFound;

}
