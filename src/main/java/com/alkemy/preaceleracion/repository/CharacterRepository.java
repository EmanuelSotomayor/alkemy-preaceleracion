package com.alkemy.preaceleracion.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.alkemy.preaceleracion.entity.Character;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long>{
	@Query("SELECT pj FROM Character pj WHERE pj.name = :name")
	public Optional<Character> getCharacterFilterByName(@Param(value = "name") String name);
	@Query("SELECT pj FROM Character pj WHERE pj.age = :age")
	public List<Character> getCharactersFilterByAge(@Param(value = "age") Integer age);
	@Query("SELECT pj FROM Character pj WHERE pj.weight = :weight")
	public List<Character> getCharactersFilterByWeight(@Param(value = "weight") Float weight);
	/*@Query("SELECT pj FROM Character pj WHERE pj.idMovie = :idMovieSerie")
	public List<Character> getCharactersFilterByMovieOrSerie(@Param(value = "idMovieSerie") Long idMovieSerie);*/
}