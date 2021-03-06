package com.zee.zee5app.dto;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name="movies",uniqueConstraints = @UniqueConstraint(columnNames = "moviename"))
public class Movies {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
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
//public Movies()
//{
//	
//}
//	public Movies(String id, String moviename, int age_limit, String cast, String genre, 
//			String trailer, String releasedate, String language) {
//		super();
//		this.id = id;
//		this.moviename = moviename;
//		this.age_limit = age_limit;
//		this.cast = cast;
//		this.genre = genre;
////		this.length = length;
//		this.trailer = trailer;
//		this.releasedate = releasedate;
//		this.language = language;
//	}
	@NotBlank  //large object binaries
	private String trailer;
	@NotNull
	private Date releaseDate;
	@NotBlank
	private String  language;
	
		
	
//		private List<String> allowed_locations;
	@NotBlank
	private String category;



	public Movies(String movieName, int ageLimit, String cast,  String genre,
			 BigDecimal length,  String trailer,  Date releaseDate,  String language,
			 String category) {
		//super();
		this.movieName = movieName;
		this.ageLimit = ageLimit;
		this.cast = cast;
		this.genre = genre;
		this.length = length;
		this.trailer = trailer;
		this.releaseDate = releaseDate;
		this.language = language;
		this.category = category;
	}
	
	

}
