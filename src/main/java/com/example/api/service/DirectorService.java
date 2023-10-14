package com.example.api.service;

import com.example.api.model.Director;
import com.example.api.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorService {
    private final DirectorRepository directorRepository;

    @Autowired
    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    public List<Director> getAllDirectors() {
        return directorRepository.getAllDirectors();
    }

    public Director getDirectorById(Long id) {
        return directorRepository.getDirectorById(id);
    }

    public String addDirector(String name) {
        directorRepository.addDirector(new Director(name));
        return "The director has been added.";
    }

    public String updateDirector(Long id, String name) {
        Director director = this.directorRepository.getDirectorById(id);
        if (director != null) {
            directorRepository.updateDirectorName(director, name);
            return "The director has been updated.";
        }
        return "The director wasn't found.";
    }

    public String deleteDirector(Long id) {
        Director director = directorRepository.getDirectorById(id);
        if (director != null) {
            directorRepository.deleteDirectorById(id);
            return "The director has been deleted.";
        }
        return "The director wasn't found.";
    }
}
