package com.alkemy.preaceleracion.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.alkemy.preaceleracion.entity.MovieSerie;

@Repository
public interface MovieSerieRepository extends JpaRepository<MovieSerie, Long>{
	@Query("SELECT m FROM MovieSerie m WHERE m.title LIKE %:name%")
	public List<MovieSerie> getMovieSeriesFilterByName(@Param(value = "name") String name);
	@Query("SELECT m FROM MovieSerie m JOIN m.genres mg ON mg.id = :genre")
	public List<MovieSerie> getMovieSeriesFilterByIdGenre(@Param(value = "genre") Long genre);
	@Query("SELECT m FROM MovieSerie m ORDER BY m.title ASC")
	public List<MovieSerie> getMovieSeriesASCSort();
	@Query("SELECT m FROM MovieSerie m ORDER BY m.title DESC")
	public List<MovieSerie> getMovieSeriesDESCSort();
}
