package com.example.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Genre;
import com.example.services.IGenre;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/genre")
public class GenreController {

	@Autowired
	private IGenre genreServices;

	@GetMapping("/getGenres")
	public List<Genre> getGenres() {
		return genreServices.getGenres();
	}

	@GetMapping("/getGenresById/{id}")
	public Optional<Genre> getGenreById(@PathVariable Integer id) {
		return genreServices.getGenre(id);
	}

	@GetMapping("/getGenreByName/{name}")
	public Optional<Genre> getGenreByName(@PathVariable String name) {
		return genreServices.getGenreByName(name);
	}

	@DeleteMapping("/deleteGenre/{id}")
	public void deleteGenre(@PathVariable Integer id) {
		genreServices.deleteGenre(id);
	}

	@PutMapping("/updateGenre/{id}")
	public void updateGenre(@RequestBody Genre genre, @PathVariable Integer id) {
		genreServices.updateGenre(genre, id);
	}


	@PostMapping("/addGenre")
	public void addGenre(@RequestBody Genre g) {
		genreServices.addGenre(g);
	}
	
	
}
