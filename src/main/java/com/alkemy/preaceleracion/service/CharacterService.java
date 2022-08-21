package com.alkemy.preaceleracion.service;

import java.util.List;
import com.alkemy.preaceleracion.DTO.CharacterDTO;
import com.alkemy.preaceleracion.entity.MovieSerie;

public interface CharacterService {
	public CharacterDTO saveCharacter(CharacterDTO characterDTO);
	public void deleteCharacterById(Long id);
	public CharacterDTO updateCharacterById(Long id, CharacterDTO characterDTO);
	public CharacterDTO getCharacterById(Long id);
	public List<CharacterDTO> getAllCharacters();
	/*public CharacterDTO getCharacterFilterByName(String name);
	public List<CharacterDTO> getCharactersFilterByAge(Integer age);
	public List<CharacterDTO> getCharactersFilterByWeight(Float weight);
	public List<MovieSerie> getCharacterMoviesById(Long id);*/
}