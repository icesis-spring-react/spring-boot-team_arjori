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
        return directors;
    }

    public Director getDirectorById(Long id) {
        return directors.stream().filter(director -> director.getId().equals(id)).findFirst().orElse(null);
    }

    public void addDirector(Director director) {
        directors.add(director);
    }

    public void updateDirectorName(Director director, String name) {
        director.setName(name);
    }

    public void deleteDirectorById(Long id) {
        directors.removeIf(director -> director.getId().equals(id));
    }
}
