package com.alkemy.preaceleracion.controller;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.alkemy.preaceleracion.service.CharacterService;
import com.alkemy.preaceleracion.entity.Character;
import com.alkemy.preaceleracion.entity.MovieSerie;

@RestController
@RequestMapping("/characters")
public class CharacterController {
	
	@Autowired
	private CharacterService characterService;
	
	@PostMapping
	public ResponseEntity<Character> saveCharacter(@Valid @RequestBody Character character){
		return ResponseEntity.status(HttpStatus.CREATED).body(characterService.saveCharacter(character));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Character> updateCharacterById(@Valid @PathVariable Long id, @Valid @RequestBody Character character){
		return ResponseEntity.status(HttpStatus.OK).body(characterService.updateCharacterById(id, character));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCharacterById(@Valid @PathVariable Long id){
		characterService.deleteCharacterById(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Character> getCharacterById(@Valid @PathVariable Long id){
		return ResponseEntity.status(HttpStatus.FOUND).body(characterService.getCharacterById(id));
	}
	
	@GetMapping
	public ResponseEntity<List<Character>> getAllCharacters(){
		return ResponseEntity.status(HttpStatus.FOUND).body(characterService.getAllCharacters());
	}
	
	/*Hay que pasarle la propiedad params, en este caso el valor 'name',
	ya que sí lo dejamos vacio va a haber un conflicto
	entre endpoints, porque quedaría /characters y ese ya existe en el @RequestMapping*/
	//Al final queda: http://localhost:8080/characters?name=valor
	@GetMapping(params = "name")
	public ResponseEntity<Character> getCharacterFilterByName(@Valid @RequestParam String name){
		return ResponseEntity.status(HttpStatus.FOUND).body(characterService.getCharacterFilterByName(name));
	}
	
	@GetMapping(params = "age")
	public ResponseEntity<List<Character>> getCharactersFilterByAge(@Valid @RequestParam Integer age){
		return ResponseEntity.status(HttpStatus.FOUND).body(characterService.getCharactersFilterByAge(age));
	}
	
	@GetMapping(params = "weight")
	public ResponseEntity<List<Character>> getCharactersFilterByWeight(@Valid @RequestParam Float weight){
		return ResponseEntity.status(HttpStatus.FOUND).body(characterService.getCharactersFilterByWeight(weight));
	}
	
	@GetMapping("/{id}/movies")
	public ResponseEntity<List<MovieSerie>> getCharacterMoviesById(@Valid @PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(characterService.getCharacterMoviesById(id));
	}
	
}