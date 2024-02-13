package com.example.services;

import java.util.List;
import java.util.Optional;

import com.example.entities.Genre;

public interface IGenre {
	void addGenre(com.example.entities.Genre genre);

	List<Genre> getGenres(); 

	void deleteGenre(Integer id);

	void updateGenre(Genre genre, Integer id);

	Optional<Genre> getGenre(Integer id); 

	Optional<Genre> getGenreByName(String name);

}
