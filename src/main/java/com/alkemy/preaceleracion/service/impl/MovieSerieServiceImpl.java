package com.alkemy.preaceleracion.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alkemy.preaceleracion.entity.MovieSerie;
import com.alkemy.preaceleracion.exception.MovieSerieException;
import com.alkemy.preaceleracion.repository.MovieSerieRepository;
import com.alkemy.preaceleracion.service.MovieSerieService;

@Service
public class MovieSerieServiceImpl implements MovieSerieService{

	@Autowired
	private MovieSerieRepository movieSerieRepository;
	
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

}
