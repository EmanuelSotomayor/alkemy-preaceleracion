package com.alkemy.preaceleracion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alkemy.preaceleracion.service.CharacterService;
import com.alkemy.preaceleracion.entity.Character;

@RestController
@RequestMapping("/characters")
public class CharacterController {
	
	@Autowired
	private CharacterService characterService;
	
	@PostMapping
	public ResponseEntity<Character> saveCharacter(@RequestBody Character character){
		return ResponseEntity.status(HttpStatus.CREATED).body(characterService.saveCharacter(character));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Character> updateCharacterById(@PathVariable Long id, @RequestBody Character character){
		return ResponseEntity.status(HttpStatus.OK).body(characterService.updateCharacterById(id, character));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCharacterById(@PathVariable Long id){
		characterService.deleteCharacterById(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Character> getCharacterById(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.FOUND).body(characterService.getCharacterById(id));
	}
	
	@GetMapping
	public ResponseEntity<List<Character>> getAllCharacters(){
		return ResponseEntity.status(HttpStatus.FOUND).body(characterService.getAllCharacters());
	}
	
}
