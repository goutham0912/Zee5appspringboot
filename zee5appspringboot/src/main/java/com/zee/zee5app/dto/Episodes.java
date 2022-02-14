package com.zee.zee5app.dto;

import java.math.BigDecimal;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Long id;
	@NotBlank
	private String name;
	@NotNull
	private BigDecimal length;
	@NotBlank
	private String location;
	@NotBlank
	private String trailer;
//	@NotBlank
//	private String seriesId;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="seriesId")  //used in creating a foreign key column  
//	@JsonProperty(access=Access.WRITE_ONLY)
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Series series; //series id and it should act as FK
//	public Episodes()
//	{
//		
//	}
	public Episodes( String name, BigDecimal length, String location, String trailer,Series series) {
		
		this.name = name;
		this.length = length;
		this.location = location;
		this.trailer = trailer;
		this.series=series;
		
	}

}
