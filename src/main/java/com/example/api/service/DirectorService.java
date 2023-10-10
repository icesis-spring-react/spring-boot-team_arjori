package com.example.api.service;

import com.example.api.model.Director;
import com.example.api.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorService {
    @Autowired
    private DirectorRepository directorRepository;

    public List<Director> geAllDirectors() {
        return this.directorRepository.getAllDirectors();
    }

    public Director getDirector(Long id) {
        return this.directorRepository.getDirectorById(id);
    }

    public Director addDirector(String name) {
        Director director = new Director(name);
        return this.directorRepository.addDirector(director);
    }

    public String updateDirector(Long id, String name) {
        Director director = this.directorRepository.getDirectorById(id);
        if (director != null) {
            this.directorRepository.updateDirector(director, name);
            return "Director updated";
        }
        return "Director not found";
    }

    public String deleteDirector(Long id) {
        Director director = this.directorRepository.getDirectorById(id);
        if (director != null) {
            this.directorRepository.deleteDirector(id);
            return "Director deleted";
        }
        return "Director not found";
    }
}
