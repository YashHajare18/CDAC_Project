package com.example.services;


import java.util.List;

import com.example.entities.Language;


public interface ILanguageManager {
    List<Language> getAllLanguages();
    Language getLanguageById(int id);
    Language saveLanguage(Language language);
    void deleteLanguage(int id);
}