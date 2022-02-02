package com.zee.zee5app.dto;



import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.zee.zee5app.dto.Series;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "name")},name="Series")
public class Series implements Comparable<Series> {
	@Id
	@Column(name="id")
	private String seriesid;
	@NotBlank
	
	private String name;
	@Max(value=70)
	private int age_limit;
	@NotBlank
	private String cast;
	@NotBlank
	private String genre;
	@NotBlank
	private String trailer;
	@NotNull
	private Date releasedate;
	@NotBlank
	private String language;
	@Min(value=1)
	private int no_episodes;
//	private String episodenames[];
	
	@Override
	public int compareTo(Series o) {
		// TODO Auto-generated method stub
		return this.seriesid.compareTo(o.getSeriesid());
	}
//	public Series() {
//		
//	}
//	public Series(String seriesid, String name, int age_limit, String cast, String genre, BigDecimal length,
//			String trailer, String releasedate, String language, int no_episodes) {
//		super();
//		this.seriesid = seriesid;
//		this.name = name;
//		this.age_limit = age_limit;
//		this.cast = cast;
//		this.genre = genre;
//		this.length = length;
//		this.trailer = trailer;
//		this.releasedate = releasedate;
//		this.language = language;
//		this.no_episodes = no_episodes;
//	}

}
