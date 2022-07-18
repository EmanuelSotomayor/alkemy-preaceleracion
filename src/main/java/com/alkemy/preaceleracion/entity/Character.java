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

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "characters")
public class Character {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "name", length = 45, nullable = false)
	private String name;
	@Column(name = "age", nullable = false)
	private Integer age;
	@Column(name = "weight", nullable = false)
	private Float weight;
	@Column(name = "history", columnDefinition = "TEXT", nullable = false)
	private String history;
	@Column(name = "image")
	private String imageUrl;
	@JsonBackReference
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "characters")
	private List<MovieSerie> moviesSeries;

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

	public List<MovieSerie> getMoviesSeries() {
		return moviesSeries;
	}

	public void setMoviesSeries(List<MovieSerie> moviesSeries) {
		this.moviesSeries = moviesSeries;
	}
	
	// toString()
	@Override
	public String toString() {
		return "Character [id=" + id + ", name=" + name + ", age=" + age + ", weight=" + weight + ", history=" + history
				+ ", imageUrl=" + imageUrl + ", moviesSeries=" + moviesSeries + "]";
	}
}