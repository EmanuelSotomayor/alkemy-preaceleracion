package com.alkemy.preaceleracion.service;

import java.util.List;
import com.alkemy.preaceleracion.entity.Genre;

public interface GenreService {
	public Genre saveGenre(Genre genre);
	public void deleteGenreById(Long id);
	public Genre updateGenreById(Long id, Genre genre);
	public Genre getGenreById(Long id);
	public List<Genre> getAllGenres();
}
