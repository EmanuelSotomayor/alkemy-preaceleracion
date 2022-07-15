package com.alkemy.preaceleracion.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import com.alkemy.preaceleracion.enumeration.GenreType;

@Entity
@Table(name = "genres")
public class Genre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "name", columnDefinition = "ENUM('MALE', 'FEMALE', 'OTHER')" ,nullable = false)
	@Enumerated(EnumType.STRING)
	private GenreType genreType;
	@Column(name = "image", length = 255, nullable = false)
	private String imgUrl;
	@ManyToMany(mappedBy = "genres", cascade = CascadeType.ALL)
	private List<MovieSerie> moviesSeries;
	
	//Empty constructor
	public Genre(){}
	
	//Parametized constructor
	public Genre(Long id, GenreType genreType, String imgUrl){
		this.id = id;
		this.genreType = genreType;
		this.imgUrl = imgUrl;
	}
	
	//Getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public GenreType getGenreType() {
		return genreType;
	}

	public void setGenreType(GenreType genreType) {
		this.genreType = genreType;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	//toString()
	@Override
	public String toString() {
		return "Genre [id=" + id + ", genreType=" + genreType + ", imgUrl=" + imgUrl + "]";
	}
	
}
