package com.example.api.controller;

import com.example.api.model.Director;
import com.example.api.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DirectorController {
    private final DirectorService directorService;

    @Autowired
    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @GetMapping("/directors")
    public List<Director> getAllDirectors() {
        return directorService.getAllDirectors();
    }

    @GetMapping("/director/{id}")
    public Director getDirectorById(@PathVariable String id) {
        return directorService.getDirectorById(Long.parseLong(id));
    }

    @PostMapping("/director")
    public String addDirector(@RequestBody Director director) {
        return directorService.addDirector(director.getName());
    }

    @PutMapping("/director/{id}")
    public String updateDirector(@PathVariable String id, @RequestBody Director director) {
        return directorService.updateDirector(Long.parseLong(id), director.getName());
    }

    @DeleteMapping("/director/{id}")
    public String deleteDirector(@PathVariable String id) {
        return directorService.deleteDirector(Long.parseLong(id));
    }
}
