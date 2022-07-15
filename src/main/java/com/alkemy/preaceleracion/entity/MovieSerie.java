package com.alkemy.preaceleracion.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "movies_series")
public class MovieSerie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "title", length = 100, nullable = false)
	private String title;
	@Column(name = "creation_date")
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date creationDate;
	@Column(name = "calification")
	private Integer calification;
	@Column(name = "image", length = 255, nullable = false)
	private String imgUrl;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(
			name = "movies_series_genres",
			joinColumns = @JoinColumn(name = "id_movie_serie"),
			inverseJoinColumns = @JoinColumn(name = "id_genre")
	)
	private List<Genre> genres;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(
			name = "movies_series_characters",
			joinColumns = @JoinColumn(name = "id_movie_serie"),
			inverseJoinColumns = @JoinColumn(name = "id_character")
	)
	private List<Character> characters;

	// Empty constructor
	public MovieSerie() {}

	// Parametized constructor
	public MovieSerie(Long id, String title, Date creationDate, Integer calification, String imgUrl) {
		this.id = id;
		this.title = title;
		this.creationDate = creationDate;
		this.calification = calification;
		this.imgUrl = imgUrl;
	}
	
	//Getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public void addGenre(Genre genre){
		this.genres.add(genre);
	}
	
	public void addCharacter(Character character){
		this.characters.add(character);
	}
	
	public void deleteCharacter(Character character){
		this.characters.remove(character);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Integer getCalification() {
		return calification;
	}

	public void setCalification(Integer calification) {
		this.calification = calification;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	public List<Genre> getGenres(){
		return genres;
	}
	
	public void setGenres(List<Genre> genres){
		this.genres = genres;
	}
	
	public List<Character> getCharacters(){
		return characters;
	}
	
	public void setCharacters(List<Character> characters){
		this.characters = characters;
	}
	
	//toString()
	@Override
	public String toString() {
		return "MovieSerie [id=" + id + ", title=" + title + ", creationDate=" + creationDate + ", calification="
				+ calification + ", imgUrl=" + imgUrl + ", genres=" + genres + ", characters=" + characters + "]";
	}

}
