package com.alkemy.preaceleracion.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "genres")
public class Genre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@NotNull(message = "ID may not be null")
	private Long id;
	@NotEmpty(message = "Name may not be empty")
	@Size(min = 4, message = "Name should have at least 4 characters")
	@Column(name = "name", length = 100, nullable = false)
	private String genreName;
	@NotEmpty(message = "URL may not be empty")
	@Column(name = "image", length = 255, nullable = false)
	private String imgUrl;
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "genres")
	private Set<MovieSerie> moviesSeries = new HashSet<>();
	
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

	@Override
	public int hashCode() {
		return Objects.hash(genreName, id, imgUrl, moviesSeries);
	}
	
	//Equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Genre other = (Genre) obj;
		return Objects.equals(genreName, other.genreName) && Objects.equals(id, other.id)
				&& Objects.equals(imgUrl, other.imgUrl) && Objects.equals(moviesSeries, other.moviesSeries);
	}
	
}
