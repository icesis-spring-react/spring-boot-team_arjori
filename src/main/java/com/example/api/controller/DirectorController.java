package com.example.api.controller;

import com.example.api.model.Director;
import com.example.api.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class DirectorController {

    @Autowired
    private DirectorService directorService;

    @GetMapping("/directors")
    public List<Director> getDirectors() {
        return this.directorService.geAllDirectors();
    }

    @GetMapping("/director/{id}")
    public Director getDirector(@PathVariable String id) {
        return this.directorService.getDirector(Long.parseLong(id));
    }

    @PostMapping("/director")
    public Director addDirector(@RequestBody Director director) {
        return this.directorService.addDirector(director.getName());
    }

    @PutMapping("/director/{id}")
    public String updateDirector(@PathVariable String id, @RequestBody Director director) {
        return this.directorService.updateDirector(Long.parseLong(id), director.getName());
    }

    @DeleteMapping("/director/{id}")
    public String deleteDirector(@PathVariable String id) {
        return this.directorService.deleteDirector(Long.parseLong(id));
    }
}
