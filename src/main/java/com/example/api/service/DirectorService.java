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

    public List<Director> getAllDirectors() {
        return this.directorRepository.findAll();
    }

    public Director getDirectorById(Long id) {
        return this.directorRepository.findById(id).orElse(null);
    }

    public String addDirector(String name) {
        this.directorRepository.save(new Director(name));
        return "The director has been added.";
    }

    public String updateDirector(Long id, String name) {
        Director director = this.directorRepository.findById(id).orElse(null);
        if (director != null) {
            director.setName(name);
            this.directorRepository.save(director);
            return "The director has been updated.";
        }
        return "The director wasn't found.";
    }

    public String deleteDirector(Long id) {
        Director director = this.directorRepository.findById(id).orElse(null);
        if (director != null) {
            this.directorRepository.delete(director);
            return "The director has been deleted.";
        }
        return "The director wasn't found.";
    }
}
