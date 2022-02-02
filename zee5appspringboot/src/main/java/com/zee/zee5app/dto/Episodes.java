package com.zee.zee5app.dto;

import java.math.BigDecimal;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Episodes")
public class Episodes {
	@Id
	@Column(name="id")
	private String id;
	@NotBlank
	private String name;
	@NotNull
	private BigDecimal length;
	@NotBlank
	private String location;
	@NotBlank
	private String trailer;
	@NotBlank
	private String series_id;
//	public Episodes()
//	{
//		
//	}
//	public Episodes(String id, String name, BigDecimal length, String location, String trailer, String series_id) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.length = length;
//		this.location = location;
//		this.trailer = trailer;
//		this.series_id = series_id;
//	}

}
