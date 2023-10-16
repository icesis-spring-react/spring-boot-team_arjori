package com.example.api.model;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Film {
    private Long id;
    private String title;
    private String genre;
    private String director;
    private Date releaseDate;

    public Film() {
    }

    public Film(Long id, String title, String genre, String director, Date releaseDate) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.releaseDate = releaseDate;
    }

    public Film(String title, String genre, String director, Date releaseDate) {
        this.id = new Date().getTime();
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.releaseDate = releaseDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}
