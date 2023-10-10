package com.example.api.repository;

import com.example.api.model.Director;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DirectorRepository {

    private final List<Director> directors = new ArrayList<>();

    public DirectorRepository() {
        directors.add(new Director("Quentin Tarantino"));
        directors.add(new Director("Martin Scorsese"));
        directors.add(new Director("Christopher Nolan"));
        directors.add(new Director("Steven Spielberg"));
        directors.add(new Director("David Fincher"));
        directors.add(new Director("Stanley Kubrick"));
        directors.add(new Director("Alfred Hitchcock"));
        directors.add(new Director("Francis Ford Coppola"));
        directors.add(new Director("Sergio Leone"));
        directors.add(new Director("Akira Kurosawa"));
    }

    public List<Director> getAllDirectors() {
        return this.directors;
    }

    public Director getDirectorById(Long id) {
        return this.directors.stream().filter(director -> director.getId().equals(id)).findFirst().orElse(null);
    }

    public Director addDirector(Director director) {
        this.directors.add(director);
        return director;
    }

    public Director updateDirector(Director director, String name) {
        director.setName(name);
        return director;
    }

    public void deleteDirector(Long id) {
        this.directors.removeIf(director -> director.getId().equals(id));
    }
}
