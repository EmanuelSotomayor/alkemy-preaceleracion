package com.alkemy.preaceleracion.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.alkemy.preaceleracion.entity.Genre;
import com.alkemy.preaceleracion.exception.GenreException;
import com.alkemy.preaceleracion.repository.GenreRepository;
import com.alkemy.preaceleracion.service.GenreService;

@Service
public class GenreServiceImpl implements GenreService{
	
	@Autowired
	private GenreRepository genreRepository;
	
	@Override
	@Transactional
	public Genre saveGenre(Genre genre) {
		return genreRepository.save(genre);
	}

	@Override
	@Transactional
	public void deleteGenreById(Long id) {
		Optional<Genre> genreIsPresent = genreRepository.findById(id);
		genreIsPresent.orElseThrow(()-> new GenreException("Genre doesn't exists"));
		genreRepository.deleteById(id);
	}

	@Override
	@Transactional
	public Genre updateGenreById(Long id, Genre genre) {
		Optional<Genre> genreIsPresent = genreRepository.findById(id);
		genreIsPresent.orElseThrow(()-> new GenreException("Genre doesn't exists"));
		genreIsPresent.get().setGenreType(genre.getGenreType());
		genreIsPresent.get().setImgUrl(genre.getImgUrl());
		return genreRepository.save(genreIsPresent.get());
	}

	@Override
	@Transactional(readOnly = true)
	public Genre getGenreById(Long id) {
		Optional<Genre> genreIsPresent = genreRepository.findById(id);
		return genreIsPresent.orElseThrow(()-> new GenreException("Genre doesn't exists"));
	}

	@Override
	@Transactional(readOnly = true)
	public List<Genre> getAllGenres() {
		return genreRepository.findAll();
	}

}
