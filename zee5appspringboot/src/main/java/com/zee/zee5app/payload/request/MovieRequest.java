package com.zee.zee5app.payload.request;

import java.math.BigDecimal;
import java.sql.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
@Data
public class MovieRequest {
	@NotBlank
	private String movieName;
	@Max(value = 70)
	private int ageLimit;
	@NotBlank
	private String cast;
	@NotBlank
	private String genre;
	@NotNull
	private BigDecimal length;
	@NotBlank  //large object binaries
	private String trailer;
	@NotNull
	private String releaseDate;
	@NotBlank
	private String  language;
	
		
	
//		private List<String> allowed_locations;
	@NotBlank
	private String category;
}
