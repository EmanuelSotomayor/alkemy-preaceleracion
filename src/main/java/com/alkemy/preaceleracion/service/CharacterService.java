package com.alkemy.preaceleracion.service;

import java.util.List;
import com.alkemy.preaceleracion.entity.Character;


public interface CharacterService {
	public Character saveCharacter(Character character);
	public void deleteCharacterById(Long id);
	public Character updateCharacterById(Long id, Character character);
	public Character getCharacterById(Long id);
	public List<Character> getAllCharacters();
}
