package com.example.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entities.Genre;

public interface IGenreRepository extends JpaRepository<Genre, Integer> {

	@Modifying
	@Query("update Genre g set g.genredesc = :genredesc WHERE g.genreid = :genreid")
	void update(@Param("genredesc") String genreDesc, @Param("genreid") Integer id);

	@Query("select g from Genre g where g.genredesc = :genredesc ")
	Optional<Genre> findByGenreDesc(@Param("genredesc") String genreDesc);

}
