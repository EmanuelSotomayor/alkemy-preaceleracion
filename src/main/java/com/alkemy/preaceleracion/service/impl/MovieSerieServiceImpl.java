package com.alkemy.preaceleracion.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.alkemy.preaceleracion.entity.Genre;
import com.alkemy.preaceleracion.entity.Character;
import com.alkemy.preaceleracion.entity.MovieSerie;
import com.alkemy.preaceleracion.exception.CharacterException;
import com.alkemy.preaceleracion.exception.GenreException;
import com.alkemy.preaceleracion.exception.MovieSerieException;
import com.alkemy.preaceleracion.repository.CharacterRepository;
import com.alkemy.preaceleracion.repository.GenreRepository;
import com.alkemy.preaceleracion.repository.MovieSerieRepository;
import com.alkemy.preaceleracion.service.MovieSerieService;

@Service
public class MovieSerieServiceImpl implements MovieSerieService{

	@Autowired
	private MovieSerieRepository movieSerieRepository;
	
	@Autowired
	private GenreRepository genreRepository;
	
	@Autowired
	private CharacterRepository characterRepository;
	
	@Override
	@Transactional
	public MovieSerie saveMovieSerie(MovieSerie movieSerie) {
		return movieSerieRepository.save(movieSerie);
	}

	@Override
	@Transactional
	public void deleteMovieSerieById(Long id) {
		Optional<MovieSerie> movieSerieIsPresent = movieSerieRepository.findById(id);
		movieSerieIsPresent.orElseThrow(()-> new MovieSerieException("Movie or serie doesn't exists"));
		movieSerieRepository.deleteById(id);
	}

	@Override
	@Transactional
	public MovieSerie updateMovieSerieById(Long id, MovieSerie movieSerie) {
		Optional<MovieSerie> movieSerieIsPresent = movieSerieRepository.findById(id);
		movieSerieIsPresent.orElseThrow(()-> new MovieSerieException("Movie or serie doesn't exists,"
				+ "cannot be updated"));
		movieSerieIsPresent.get().setTitle(movieSerie.getTitle());
		movieSerieIsPresent.get().setImgUrl(movieSerie.getImgUrl());
		movieSerieIsPresent.get().setCreationDate(movieSerie.getCreationDate());
		movieSerieIsPresent.get().setCalification(movieSerie.getCalification());
		return movieSerieRepository.save(movieSerieIsPresent.get());
	}

	@Override
	@Transactional(readOnly = true)
	public MovieSerie getMovieSerieById(Long id) {
		Optional<MovieSerie> movieSerieIsPresent = movieSerieRepository.findById(id);
		return movieSerieIsPresent.orElseThrow(()-> new MovieSerieException("Movie or serie doesn't exists"));
	}

	@Override
	@Transactional(readOnly = true)
	public List<MovieSerie> getAllMoviesSeries() {
		return movieSerieRepository.findAll();
	}
	
	private Boolean checkIfGenresExists(List<Genre> genres){
		List<Long> idGenres = new ArrayList<>();
		for(Genre g: genres){
			Optional<Genre> actualId = genreRepository.findById(g.getId());
			actualId.orElseThrow(()-> new GenreException(g + " doesn't exists"));
				if(actualId.get().getId().equals(g.getId())){
					idGenres.add(actualId.get().getId());
				}
		}
		return idGenres != null;
	}
	
	private Boolean checkIfCharactersExists(List<Character> characters){
		List<Long> idCharacters = new ArrayList<>();
			for(Character c: characters){
				Optional<Character> actualId = characterRepository.findById(c.getId());
				actualId.orElseThrow(()-> new CharacterException(c + " doesn't exists"));
					if(actualId.get().getId().equals(c.getId())){
						idCharacters.add(actualId.get().getId());
					}
			}
		return idCharacters != null;
	}
	
	private Character checkIfCharacterExists(Long idCharacter){
		Optional<Character> characterIsPresent = characterRepository.findById(idCharacter);
		characterIsPresent.orElseThrow(()-> new CharacterException("character doesn't exists"));
		return characterIsPresent.get();
	}
	
	@Override
	public MovieSerie addGenres(Long id, List<Genre> genres) {
		Optional<MovieSerie> movieSerieIsPresent = movieSerieRepository.findById(id);
		movieSerieIsPresent.orElseThrow(()-> new MovieSerieException("Movie or serie doesn't exists"));
		if(checkIfGenresExists(genres)){
			genres.forEach((Genre genre)->{
				movieSerieIsPresent.get().addGenre(genre);
			});
		}else{
			throw new GenreException("Genre's doesn't exists");
		}
		return movieSerieRepository.save(movieSerieIsPresent.get());
	}

	@Override
	public MovieSerie addCharacters(Long id, List<Character> characters) {
		Optional<MovieSerie> movieSerieIsPresent = movieSerieRepository.findById(id);
		movieSerieIsPresent.orElseThrow(()-> new MovieSerieException("Movie or serie doesn't exists"));
		if(checkIfCharactersExists(characters)){
			characters.forEach((Character character)->{
				movieSerieIsPresent.get().addCharacter(character);
			});
		}
		return movieSerieRepository.save(movieSerieIsPresent.get());
	}

	@Override
	public void addCharacter(Long idMovie, Long idCharacter) {
		Optional<MovieSerie> movieSerieIsPresent = movieSerieRepository.findById(idMovie);
		movieSerieIsPresent.orElseThrow(()-> new MovieSerieException("Movie or serie doesn't exists"));
		movieSerieIsPresent.get().addCharacter(checkIfCharacterExists(idCharacter));
		movieSerieRepository.save(movieSerieIsPresent.get());
	}

	@Override
	public void deleteCharacter(Long idMovie, Long idCharacter) {
		Optional<MovieSerie> movieSerieIsPresent = movieSerieRepository.findById(idMovie);
		movieSerieIsPresent.orElseThrow(()-> new MovieSerieException("Movie or serie doesn't exists"));
		movieSerieIsPresent.get().deleteCharacter(checkIfCharacterExists(idCharacter));
		movieSerieRepository.save(movieSerieIsPresent.get());
	}

	@Override
	public List<MovieSerie> getMovieSeriesFilterByIdGenre(Long genre) {
		Optional<Genre> genreIsPresent = genreRepository.findById(genre);
		genreIsPresent.orElseThrow(()-> new GenreException("Genre isn't exists"));
		return movieSerieRepository.getMovieSeriesFilterByIdGenre(genre);
	}

	@Override
	public List<MovieSerie> getMovieSeriesSortFilter(String order) {
		if(order.equals("ASC")){
			return movieSerieRepository.getMovieSeriesASCSort();
		}if(order.equals("DESC")){
			return movieSerieRepository.getMovieSeriesDESCSort();
		}
		return null;
	}

	@Override
	public List<MovieSerie> getMovieSeriesFilterByName(String name) {
		return movieSerieRepository.getMovieSeriesFilterByName(name);
	}
	
}