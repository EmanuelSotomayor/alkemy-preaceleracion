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
import org.hibernate.validator.constraints.Range;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "characters")
public class Character {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull(message = "ID may not be null")
	@Column(name = "id")
	private Long id;
	@NotEmpty(message = "Name may not be empty")
	@Size(min = 3, message = "Name should have at least 3 characters")
	@Column(name = "name", length = 45, nullable = false)
	private String name;
	@NotEmpty(message = "Age may not be empty")
	@Range(min = 1L, message = "Please select positive numbers only")
	@Column(name = "age", nullable = false)
	private Integer age;
	@NotEmpty(message = "Weight may not be empty")
	@Column(name = "weight", nullable = false)
	private Float weight;
	@NotEmpty(message = "History may not be empty")
	@Column(name = "history", columnDefinition = "TEXT", nullable = false)
	private String history;
	@NotEmpty(message = "URL may not be empty")
	@Column(name = "image")
	private String imageUrl;
	@JsonBackReference
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "characters")
	private Set<MovieSerie> moviesSeries = new HashSet<>();

	// Empty Constructor
	public Character() {}

	// Parametized constructor
	public Character(Long id, String name, Integer age, Float weight, String history, String imageUrl) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.history = history;
		this.imageUrl = imageUrl;
	}

	// Getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Set<MovieSerie> getMoviesSeries() {
		return moviesSeries;
	}

	public void setMoviesSeries(Set<MovieSerie> moviesSeries) {
		this.moviesSeries = moviesSeries;
	}
	
	// toString()
	@Override
	public String toString() {
		return "Character [id=" + id + ", name=" + name + ", age=" + age + ", weight=" + weight + ", history=" + history
				+ ", imageUrl=" + imageUrl + ", moviesSeries=" + moviesSeries + "]";
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
		Character other = (Character) obj;
		return Objects.equals(age, other.age) && Objects.equals(history, other.history) && Objects.equals(id, other.id)
				&& Objects.equals(imageUrl, other.imageUrl) && Objects.equals(moviesSeries, other.moviesSeries)
				&& Objects.equals(name, other.name) && Objects.equals(weight, other.weight);
	}
	
}