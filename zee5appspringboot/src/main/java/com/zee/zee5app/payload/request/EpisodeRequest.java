package com.zee.zee5app.payload.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.zee.zee5app.dto.Series;

import lombok.Data;
@Data
public class EpisodeRequest {
	@NotBlank
	private String name;
	@NotNull
	private BigDecimal length;
	@NotBlank
	private String location;
	@NotBlank
	private String trailer;
	private long series;
}
