package com.zee.zee5app.payload.request;

import java.sql.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
@Data
public class SeriesRequest {
	private String name;
	@Max(value=70)
	private int ageLimit;
	@NotBlank
	private String cast;
	@NotBlank
	private String genre;
	@NotBlank
	private String trailer;
	@NotNull
	private String releaseDate;
	@NotBlank
	private String language;
	@Min(value=1)
	private int noEpisodes;
}
