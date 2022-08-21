package com.alkemy.preaceleracion.DTO;

public class CharacterDTO {
	
	private Long id;
	private String name;
	private Integer age;
	private Float weight;
	private String history;
	private String imageUrl;
	
	//Empty constructor
	public CharacterDTO(){}
	
	//Parametized constructor
	public CharacterDTO(Long id, String name, Integer age, Float weight, String history,
	String imageUrl){
		this.id = id;
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.history = history;
		this.imageUrl = imageUrl;
	}
	
	//Getters and setters
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
	
	//toString()
	@Override
	public String toString() {
		return "CharacterDTO [id=" + id + ", name=" + name + ", age=" + age + ", weight=" + weight + ", history="
				+ history + ", imageUrl=" + imageUrl + "]";
	}
}