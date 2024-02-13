package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.entities.Language;
import com.example.services.ILanguageManager;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
@CrossOrigin("*")
public class LanguageController {

    @Autowired
    private ILanguageManager languageService;

    @GetMapping
    public List<Language> getAllLanguages() {
        return languageService.getAllLanguages();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Language> getLanguageById(@PathVariable int id) {
        Language language = languageService.getLanguageById(id);
        if (language != null) {
            return new ResponseEntity<>(language, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Language> saveLanguage(@RequestBody Language language) {
        return new ResponseEntity<>(languageService.saveLanguage(language), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLanguage(@PathVariable int id) {
        languageService.deleteLanguage(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}