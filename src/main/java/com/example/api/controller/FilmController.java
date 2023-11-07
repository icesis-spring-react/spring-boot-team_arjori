package com.example.api.controller;

import com.example.api.model.Director;
import com.example.api.model.Film;
import com.example.api.service.DirectorService;
import com.example.api.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FilmController {
    private final FilmService filmService;
    private final DirectorService directorService;

    @Autowired
    public FilmController(FilmService filmService, DirectorService directorService){
        this.filmService=filmService;
        this.directorService = directorService;
    }

    @GetMapping("/films")
    public List<Film> getAllFilms(){return filmService.getAllFilms();}

    @GetMapping("/film/{id}")
    public Film getFilmById(@PathVariable Long id){return filmService.getFilmById(id);}

    @GetMapping("/directors/{id}/films")
    public List<Film> getFilmsByDirector(@PathVariable String id){
        Director director = directorService.getDirectorById(Long.parseLong(id));
        if(director!=null){
            return filmService.getFilmsByDirector(director.getName());
        }
        else return null;
    }

    @PostMapping("/film")
    public String addFilm(@RequestBody Film film) {
        return filmService.addFilm(film.getTitle(), film.getGenre(),film.getDirector(),film.getReleaseDate());
    }

    @PutMapping("/film/{id}")
    public String updateFilm(@PathVariable String id, @RequestBody Film film) {
        //System.out.println("body film id:"+film.getId());
        //System.out.println("path id:"+id);
        long idlong = Long.parseLong(id);
        if(film.getId()!=null){
            if(film.getId()==idlong)
                return filmService.updateFilm(film.getId(),film.getTitle(), film.getGenre(),film.getDirector(),film.getReleaseDate());
            else return "Film ID does not match";
        }else  return filmService.updateFilm(idlong,film.getTitle(), film.getGenre(),film.getDirector(),film.getReleaseDate());
    }

    @DeleteMapping("/film/{id}")
    public String deleteFilm(@PathVariable String id) {
        return filmService.deleteFilm(Long.parseLong(id));
    }
}
