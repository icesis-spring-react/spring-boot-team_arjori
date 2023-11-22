package com.example.api.service;

import com.example.api.model.Film;
import com.example.api.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FilmService {
    private final FilmRepository filmRepository;

    @Autowired
    public FilmService(FilmRepository filmRepository){this.filmRepository=filmRepository;}

    public List<Film> getAllFilms() {return filmRepository.findAll();}

    public Film getFilmById(Long id) {return filmRepository.findById(id).orElse(null);}

    public List<Film> getFilmsByDirector(String director){return filmRepository.findFilmsByDirector(director);}

    public String addFilm(String title, String genre, String director, Date releaseDate){
        filmRepository.save(new Film(title, genre, director, releaseDate));
        return "The film has been added.";
    }

    public String updateFilm(Long id, String title, String genre, String director, Date releaseDate){
        Film film = filmRepository.findById(id).orElse(null);
        if (film!=null){
            Film newFilm = new Film(id,title,genre,director,releaseDate);
            filmRepository.save(newFilm);
            return "The film has been updated";
        }
        return "The film was not found";
    }

    public String deleteFilm(Long id){
        Film film = filmRepository.findById(id).orElse(null);
        if (film!=null){
            filmRepository.deleteById(id);
            return "The film has been deleted";
        }
        return "The film was not found";
    }
}
