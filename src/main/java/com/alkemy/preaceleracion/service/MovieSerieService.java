package com.alkemy.preaceleracion.service;

import java.util.List;
import com.alkemy.preaceleracion.entity.MovieSerie;

public interface MovieSerieService {
	public MovieSerie saveMovieSerie(MovieSerie movieSerie);
	public void deleteMovieSerieById(Long id);
	public MovieSerie updateMovieSerieById(Long id, MovieSerie movieSerie);
	public MovieSerie getMovieSerieById(Long id);
	public List<MovieSerie> getAllMoviesSeries();
}
