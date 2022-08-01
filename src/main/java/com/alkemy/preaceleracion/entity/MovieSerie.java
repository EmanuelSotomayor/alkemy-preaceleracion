package com.alkemy.preaceleracion.entity;

import java.util.Date;
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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "movies_series")
public class MovieSerie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@NotNull(message = "ID may not be null")
	private Long id;
	@NotEmpty(message = "Title may not be empty")
	@Size(min = 4, message = "Title should have at least 4 characters")
	@Column(name = "title", length = 100, nullable = false)
	private String title;
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "creation_date")
	private Date creationDate;
	@NotEmpty(message = "Calification may not be empty")
	@Size(min = 1, max = 5)
	@Column(name = "calification")
	private Integer calification;
	@NotEmpty(message = "URL may not be empty")
	@Column(name = "image", length = 255, nullable = false)
	private String imgUrl;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "movies_series_genres", joinColumns = @JoinColumn(name = "id_movie_serie"),
	inverseJoinColumns = @JoinColumn(name = "id_genre"))
	private Set<Genre> genres = new HashSet<>();
	@JsonManagedReference
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "movies_series_characters", joinColumns = @JoinColumn(name = "id_movie_serie"),
	inverseJoinColumns = @JoinColumn(name = "id_character"))
	private Set<Character> characters = new HashSet<>();

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
	
	public void removeCharacter(Character character){
		this.characters.remove(character);
		character.getMoviesSeries().remove(this);
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
	
	public Set<Genre> getGenres(){
		return genres;
	}
	
	public void setGenres(Set<Genre> genres){
		this.genres = genres;
	}
	
	public Set<Character> getCharacters(){
		return characters;
	}
	
	public void setCharacters(Set<Character> characters){
		this.characters = characters;
	}
	
	//toString()
	@Override
	public String toString() {
		return "MovieSerie [id=" + id + ", title=" + title + ", creationDate=" + creationDate + ", calification="
				+ calification + ", imgUrl=" + imgUrl + ", genres=" + genres + ", characters=" + characters + "]";
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
		MovieSerie other = (MovieSerie) obj;
		return Objects.equals(calification, other.calification) && Objects.equals(characters, other.characters)
				&& Objects.equals(creationDate, other.creationDate) && Objects.equals(genres, other.genres)
				&& Objects.equals(id, other.id) && Objects.equals(imgUrl, other.imgUrl)
				&& Objects.equals(title, other.title);
	}

}