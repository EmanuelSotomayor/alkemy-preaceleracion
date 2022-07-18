package com.alkemy.preaceleracion.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "genres")
public class Genre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "name", length = 100, nullable = false)
	private String genreName;
	@Column(name = "image", length = 255, nullable = false)
	private String imgUrl;
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "genres")
	private List<MovieSerie> moviesSeries;
	
	//Empty constructor
	public Genre(){}
	
	//Parametized constructor
	public Genre(Long id, String genreName, String imgUrl){
		this.id = id;
		this.genreName = genreName;
		this.imgUrl = imgUrl;
	}
	
	//Getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getgenreName() {
		return genreName;
	}

	public void setgenreName(String genreName) {
		this.genreName = genreName;
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
		return "Genre [id=" + id + ", genreName=" + genreName + ", imgUrl=" + imgUrl + "]";
	}
	
}
