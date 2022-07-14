package com.alkemy.preaceleracion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.alkemy.preaceleracion.entity.MovieSerie;

@Repository
public interface MovieSerieRepository extends JpaRepository<MovieSerie, Long>{

}
