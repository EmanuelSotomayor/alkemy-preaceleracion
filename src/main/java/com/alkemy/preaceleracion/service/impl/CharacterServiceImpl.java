package com.alkemy.preaceleracion.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alkemy.preaceleracion.DTO.CharacterDTO;
import com.alkemy.preaceleracion.entity.Character;
import com.alkemy.preaceleracion.entity.MovieSerie;
import com.alkemy.preaceleracion.exception.CharacterException;
import com.alkemy.preaceleracion.mapper.CharacterMapper;
import com.alkemy.preaceleracion.repository.CharacterRepository;
import com.alkemy.preaceleracion.service.CharacterService;

@Service
public class CharacterServiceImpl implements CharacterService{
	
	@Autowired
	private CharacterRepository characterRepository;
	
	@Autowired
	private CharacterMapper characterMapper;
	
	@Override
	@Transactional
	public CharacterDTO saveCharacter(CharacterDTO characterDTO) {
		Character character = characterMapper.characterDTO2Entity(characterDTO);
		Character characterSaved = characterRepository.save(character);
		return characterMapper.characterEntity2DTO(characterSaved);
	}

	@Override
	@Transactional
	public void deleteCharacterById(Long id) {
		Optional<Character> characterIsPresent = characterRepository.findById(id);
		characterIsPresent.orElseThrow(()-> new CharacterException("Character doesn't exists"));
		CharacterDTO characterDTO = characterMapper.characterEntity2DTO(characterIsPresent.get());
		characterRepository.deleteById(characterDTO.getId());
	}

	@Override
	@Transactional
	public CharacterDTO updateCharacterById(Long id, CharacterDTO characterDTO) {
		Optional<Character> characterIsPresent = characterRepository.findById(id);
		characterIsPresent.orElseThrow(()-> new CharacterException("Character doesn't exists,"
				+ " cannot be updated"));
		CharacterDTO character = characterMapper.characterEntity2DTO(characterIsPresent.get());
		character.setName(characterDTO.getName());
		character.setWeight(characterDTO.getWeight());
		character.setAge(characterDTO.getAge());
		character.setHistory(characterDTO.getHistory());
		character.setImageUrl(characterDTO.getImageUrl());
		Character characterSaved = characterRepository.save(characterMapper.characterDTO2Entity(character));
		return characterMapper.characterEntity2DTO(characterSaved);
	}

	@Override
	@Transactional(readOnly = true)
	public CharacterDTO getCharacterById(Long id) {
		Optional<Character> characterIsPresent = characterRepository.findById(id);
		characterIsPresent.orElseThrow(()-> new CharacterException("Character cannot be found"));
		CharacterDTO character = characterMapper.characterEntity2DTO(characterIsPresent.get());
		return character;
	}

	@Override
	@Transactional(readOnly = true)
	public List<CharacterDTO> getAllCharacters() {
		List<Character> characters = characterRepository.findAll();
		return characterMapper.characterEntityList2DTO(characters);
	}

/*	@Override
	public Character getCharacterFilterByName(String name) {
		Optional<CharacterDTO> characterIsPresent = characterRepository.getCharacterFilterByName(name);
		return characterIsPresent.orElseThrow(()-> new CharacterException(name + " doesn't exists"));
	}

	@Override
	public List<CharacterDTO> getCharactersFilterByAge(Integer age) {
		return characterRepository.getCharactersFilterByAge(age);
	}

	@Override
	public List<CharacterDTO> getCharactersFilterByWeight(Float weight) {
		return characterRepository.getCharactersFilterByWeight(weight);
	}

	@Override
	public List<MovieSerie> getCharacterMoviesById(Long id) {
		Optional<Character> characterIsPresent = characterRepository.findById(id); 
		characterIsPresent.orElseThrow(()-> new CharacterException(id + " doesn't exists"));
		return characterIsPresent.get().getMoviesSeries()
		.stream().filter(m -> m.getTitle() != null)
		.map(i -> new MovieSerie(i.getId(), i.getTitle(), i.getCreationDate(), i.getCalification(), i.getImgUrl()))
		.collect(Collectors.toList());
	}*/
	
}