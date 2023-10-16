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
    public List<Film> getAllFilms() {return filmRepository.getAllFilms();}
    public Film getFilmById(Long id) {return filmRepository.getFilmById(id);}
    public List<Film> getFilmsByDirector(String director){return filmRepository.getFilmsByDirector(director);}
    public String addFilm(Long id, String title, String genre, String director, Date releaseDate){
        filmRepository.addFilm(new Film(id, title, genre, director, releaseDate));
        return "The film has been added.";
    }
    public String updateFilm(Long id, String title, String genre, String director, Date releaseDate){
        Film film = filmRepository.getFilmById(id);
        if (film!=null){
            filmRepository.updateFilm(film);
            return "The film has been updated";
        }
        return "The film was not found";
    }
    public String deleteFilm(Long id){
        Film film = filmRepository.getFilmById(id);
        if (film!=null){
            filmRepository.deleteFilmById(id);
            return "The film has been deleted";
        }
        return "The film was not found";
    }
}
