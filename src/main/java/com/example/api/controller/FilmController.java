package com.example.api.controller;

import com.example.api.model.Director;
import com.example.api.model.Film;
import com.example.api.service.DirectorService;
import com.example.api.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FilmController {
    private final FilmService filmService;
    private final DirectorService directorService;
    @Autowired
    public FilmController(FilmService filmService, DirectorService directorService){
        this.filmService=filmService;
        this.directorService = directorService;
    }

    @GetMapping("/peliculas")
    public List<Film> getAllFilms(){return filmService.getAllFilms();}
    @GetMapping("/pelicula/{id}")
    public Film getFilmById(@PathVariable Long id){return filmService.getFilmById(id);}

    @GetMapping("/directores/{id}/peliculas")
    public List<Film> getFilmsByDirector(@PathVariable String id){
        Director director = directorService.getDirectorById(Long.parseLong(id));
        if(director!=null){
            return filmService.getFilmsByDirector(director.getName());
        }
        else return null;
    }

    @PostMapping("/pelicula")
    public String addFilm(@RequestBody Film film) {
        return filmService.addFilm(film.getId(), film.getTitle(), film.getGenre(),film.getDirector(),film.getReleaseDate());
    }
    @PutMapping("/pelicula/{id}")
    public String updateFilm(@PathVariable String id, @RequestBody Film film) {
        return filmService.updateFilm(film.getId(),film.getTitle(), film.getGenre(),film.getDirector(),film.getReleaseDate());
    }
    @DeleteMapping
    public String deleteFilm(@PathVariable String id) {
        return filmService.deleteFilm(Long.parseLong(id));
    }

    /*
○ GET /directores/{id}/peliculas: Listar las peliculas de un director
específico.
*/
}
