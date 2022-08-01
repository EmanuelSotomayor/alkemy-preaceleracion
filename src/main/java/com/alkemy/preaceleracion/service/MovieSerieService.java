package com.alkemy.preaceleracion.service;

import java.util.List;
import java.util.Set;
import com.alkemy.preaceleracion.entity.Genre;
import com.alkemy.preaceleracion.entity.Character;
import com.alkemy.preaceleracion.entity.MovieSerie;

public interface MovieSerieService {
	public MovieSerie saveMovieSerie(MovieSerie movieSerie);
	public void deleteMovieSerieById(Long id);
	public MovieSerie updateMovieSerieById(Long id, MovieSerie movieSerie);
	public MovieSerie getMovieSerieById(Long id);
	public List<MovieSerie> getAllMoviesSeries();
	public MovieSerie addGenres(Long id, Set<Genre> genres);
	public MovieSerie addCharacters(Long id, Set<Character> character);
	public void addCharacter(Long idMovie, Long idCharacter);
	public void deleteCharacter(Long idMovie, Long idCharacter);
	public List<MovieSerie> getMovieSeriesFilterByIdGenre(Long idGenre);
	public List<MovieSerie> getMovieSeriesSortFilter(String order);
	public List<MovieSerie> getMovieSeriesFilterByName(String name);
}
