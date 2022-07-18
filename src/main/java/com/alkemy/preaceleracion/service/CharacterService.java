package com.alkemy.preaceleracion.service;

import java.util.List;
import com.alkemy.preaceleracion.entity.Character;
import com.alkemy.preaceleracion.entity.MovieSerie;

public interface CharacterService {
	public Character saveCharacter(Character character);
	public void deleteCharacterById(Long id);
	public Character updateCharacterById(Long id, Character character);
	public Character getCharacterById(Long id);
	public List<Character> getAllCharacters();
	public Character getCharacterFilterByName(String name);
	public List<Character> getCharactersFilterByAge(Integer age);
	public List<Character> getCharactersFilterByWeight(Float weight);
	public List<MovieSerie> getCharacterMoviesById(Long id);
}