package com.alkemy.preaceleracion.DTO;

public class CharacterSimpleDTO {
	
	private Long id;
	private String name;
	private String imageUrl;
	private String history;
	
	//Empty constructor
	public CharacterSimpleDTO(){}
	
	//Parametized constructor
	public CharacterSimpleDTO(Long id, String name, String imageUrl, String history){
		this.id = id;
		this.name = name;
		this.imageUrl = imageUrl;
		this.history = history;
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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}
	
	//toString()
	@Override
	public String toString() {
		return "CharacterSimpleDTO [id=" + id + ", name=" + name + ", imageUrl=" + imageUrl + ", history=" + history
				+ "]";
	}
	
}
