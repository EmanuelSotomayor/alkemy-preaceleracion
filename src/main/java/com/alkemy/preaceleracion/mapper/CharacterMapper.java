package com.alkemy.preaceleracion.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import com.alkemy.preaceleracion.DTO.CharacterDTO;
import com.alkemy.preaceleracion.entity.Character;

@Component
public class CharacterMapper {
	
	public CharacterDTO characterEntity2DTO(Character character){
		CharacterDTO characterDTO = new CharacterDTO();
		characterDTO.setId(character.getId());
		characterDTO.setName(character.getName());
		characterDTO.setAge(character.getAge());
		characterDTO.setWeight(character.getWeight());
		characterDTO.setImageUrl(character.getImageUrl());
		characterDTO.setHistory(character.getHistory());
		return characterDTO;
	}
	
	public Character characterDTO2Entity(CharacterDTO characterDTO){
		Character character = new Character();
		character.setId(characterDTO.getId());
		character.setName(characterDTO.getName());
		character.setAge(characterDTO.getAge());
		character.setWeight(characterDTO.getWeight());
		character.setImageUrl(characterDTO.getImageUrl());
		character.setHistory(characterDTO.getHistory());
		return character;
	}
	
	//Devolvemos una lista de DTOS, recibiendo una lista de entidades
	public List<CharacterDTO> characterEntityList2DTO(List<Character> characters){
		//Creamos una lista de DTO vacias
		List<CharacterDTO> charactersDTO = new ArrayList<>();
		//Recorremos la lista de entidades que recibimos por parámetro
			for(Character character: characters){
				/*En cada iteración agregamos la entidad, previamente
				convirtiendola en un DTO*/
				charactersDTO.add(this.characterEntity2DTO(character));
			}
		return charactersDTO;
	}
	
	//Hacemos el proceso inverso
	public List<Character> characterDTO2Entities(List<CharacterDTO> charactersDTO){
		List<Character> characters = new ArrayList<>();
			for(CharacterDTO characterDTO: charactersDTO){
				characters.add(this.characterDTO2Entity(characterDTO));
			}
		return characters;
	}
}