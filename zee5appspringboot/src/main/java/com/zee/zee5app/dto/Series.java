package com.zee.zee5app.dto;



import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
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
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Long id;
	@NotBlank
	
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
	private Date releaseDate;
	@NotBlank
	private String language;
	@Min(value=1)
	private int noEpisodes;
//	private String episodenames[];
	
	@Override
	public int compareTo(Series o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}
	@OneToMany(mappedBy = "series",cascade=CascadeType.ALL,fetch=FetchType.LAZY) //series is name of foreign key
	@JsonProperty(access=Access.WRITE_ONLY)
	private List<Episodes> episodes=new ArrayList<>();
//	public Series() {
//		
//	}

	public Series(@NotBlank String name, @Max(70) int ageLimit, @NotBlank String cast, @NotBlank String genre,
			@NotBlank String trailer, @NotNull Date releaseDate, @NotBlank String language, @Min(1) int noEpisodes
			) {
		super();
		this.name = name;
		this.ageLimit = ageLimit;
		this.cast = cast;
		this.genre = genre;
		this.trailer = trailer;
		this.releaseDate = releaseDate;
		this.language = language;
		this.noEpisodes = noEpisodes;
		
	}
	

}
