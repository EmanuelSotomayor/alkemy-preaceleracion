package com.alkemy.preaceleracion.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alkemy.preaceleracion.entity.Character;
import com.alkemy.preaceleracion.exception.CharacterException;
import com.alkemy.preaceleracion.repository.CharacterRepository;
import com.alkemy.preaceleracion.service.CharacterService;

@Service
public class CharacterServiceImpl implements CharacterService{
	
	@Autowired
	private CharacterRepository characterRepository;
	
	@Override
	@Transactional
	public Character saveCharacter(Character character) {
		return characterRepository.save(character);
	}

	@Override
	@Transactional
	public void deleteCharacterById(Long id) {
		Optional<Character> characterIsPresent = characterRepository.findById(id);
		characterIsPresent.orElseThrow(()-> new CharacterException("Character doesn't exists"));
		characterRepository.deleteById(id);
	}

	@Override
	@Transactional
	public Character updateCharacterById(Long id, Character character) {
		Optional<Character> characterIsPresent = characterRepository.findById(id);
		characterIsPresent.orElseThrow(()-> new CharacterException("Character doesn't exists,"
				+ " cannot be updated"));
		characterIsPresent.get().setName(character.getName());
		characterIsPresent.get().setAge(character.getAge());
		characterIsPresent.get().setWeight(character.getWeight());
		characterIsPresent.get().setHistory(character.getHistory());
		characterIsPresent.get().setImageUrl(character.getImageUrl());
		return characterRepository.save(characterIsPresent.get());
	}

	@Override
	@Transactional(readOnly = true)
	public Character getCharacterById(Long id) {
		Optional<Character> characterIsPresent = characterRepository.findById(id);
		return characterIsPresent.orElseThrow(()-> new CharacterException("Character cannot be found"));
	}

	@Override
	@Transactional(readOnly = true)
	public List<Character> getAllCharacters() {
		return characterRepository.findAll();
	}

}
