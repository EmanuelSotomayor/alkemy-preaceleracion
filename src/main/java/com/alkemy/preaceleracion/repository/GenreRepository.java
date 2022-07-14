package com.alkemy.preaceleracion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.alkemy.preaceleracion.entity.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long>{

}
