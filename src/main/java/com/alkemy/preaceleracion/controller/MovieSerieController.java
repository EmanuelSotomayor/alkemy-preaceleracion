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
import com.alkemy.preaceleracion.entity.Genre;
import com.alkemy.preaceleracion.entity.Character;
import com.alkemy.preaceleracion.entity.MovieSerie;
import com.alkemy.preaceleracion.service.MovieSerieService;

@RestController
@RequestMapping("/movies")
public class MovieSerieController {
	
	@Autowired
	private MovieSerieService movieSerieService;
	
	@PostMapping
	public ResponseEntity<MovieSerie> saveMovieSerie(@RequestBody MovieSerie movieSerie){
		return ResponseEntity.status(HttpStatus.CREATED).body(movieSerieService.saveMovieSerie(movieSerie));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<MovieSerie> updateMovieSerieById(@PathVariable Long id, @RequestBody MovieSerie movieSerie){
		return ResponseEntity.status(HttpStatus.OK).body(movieSerieService.updateMovieSerieById(id, movieSerie));
	}
	
	@PutMapping("/{id}/addgenres")
	public ResponseEntity<MovieSerie> addGenres(@PathVariable Long id, @RequestBody List<Genre> genres){
		return ResponseEntity.status(HttpStatus.OK).body(movieSerieService.addGenres(id, genres));
	}
	
	@PutMapping("/{id}/addcharacters")
	public ResponseEntity<MovieSerie> addCharacters(@PathVariable Long id, @RequestBody List<Character> characters){
		return ResponseEntity.status(HttpStatus.OK).body(movieSerieService.addCharacters(id, characters));
	}
	
	@PutMapping("/{idMovie}/characters/{idCharacter}")
	public ResponseEntity<?> addCharacter(@PathVariable(name = "idMovie") Long idMovie, @PathVariable(name = "idCharacter") Long idCharacter){
		movieSerieService.addCharacter(idMovie, idCharacter);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteMovieSerieById(@PathVariable Long id){
		movieSerieService.deleteMovieSerieById(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@DeleteMapping("/{idMovie}/characters/{idCharacter}")
	public ResponseEntity<?> deleteCharacterOfMovie(@PathVariable(name = "idMovie") Long idMovie, @PathVariable(name = "idCharacter") Long idCharacter){
		movieSerieService.deleteCharacter(idMovie, idCharacter);
		return ResponseEntity.status(HttpStatus.OK).build();
	}	
	
	@GetMapping("/{id}")
	public ResponseEntity<MovieSerie> getMovieSerieById(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.FOUND).body(movieSerieService.getMovieSerieById(id));
	}
	
	@GetMapping
	public ResponseEntity<List<MovieSerie>> getAllMoviesSeries(){
		return ResponseEntity.status(HttpStatus.FOUND).body(movieSerieService.getAllMoviesSeries());
	}
	
}
