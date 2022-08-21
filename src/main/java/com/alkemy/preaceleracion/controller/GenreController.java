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
import com.alkemy.preaceleracion.service.GenreService;

@RestController
@RequestMapping("/genres")
public class GenreController {
	
	@Autowired
	private GenreService genreService;
	
	@PostMapping
	public ResponseEntity<Genre> saveGenre(@RequestBody Genre genre){
		return ResponseEntity.status(HttpStatus.CREATED).body(genreService.saveGenre(genre));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Genre> updateGenreById(@PathVariable Long id, @RequestBody Genre genre){
		return ResponseEntity.status(HttpStatus.OK).body(genreService.updateGenreById(id, genre));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteGenreById(@PathVariable Long id){
		genreService.deleteGenreById(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Genre> getGenreById(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.FOUND).body(genreService.getGenreById(id));
	}
	
	@GetMapping
	public ResponseEntity<List<Genre>> getAllGenres(){
		return ResponseEntity.status(HttpStatus.FOUND).body(genreService.getAllGenres());
	}
}
