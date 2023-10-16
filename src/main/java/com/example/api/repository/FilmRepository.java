package com.example.api.repository;

import com.example.api.model.Film;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class FilmRepository {
    private final List<Film> films = new ArrayList<>();

    public FilmRepository() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            // Agregar películas de Quentin Tarantino
            films.add(new Film(1L, "Pulp Fiction", "Crime", "Quentin Tarantino", dateFormat.parse("1994-10-14")));
            films.add(new Film(2L, "Kill Bill: Volume 1", "Action", "Quentin Tarantino", dateFormat.parse("2003-10-10")));
            films.add(new Film(3L, "Django Unchained", "Western", "Quentin Tarantino", dateFormat.parse("2012-12-25")));

            // Agregar películas de Martin Scorsese
            films.add(new Film(4L, "Goodfellas", "Crime", "Martin Scorsese", dateFormat.parse("1990-09-19")));
            films.add(new Film(5L, "The Departed", "Crime", "Martin Scorsese", dateFormat.parse("2006-10-06")));
            films.add(new Film(6L, "The Irishman", "Biography", "Martin Scorsese", dateFormat.parse("2019-11-27")));

            // Agregar películas de Christopher Nolan
            films.add(new Film(7L, "Inception", "Sci-Fi", "Christopher Nolan", dateFormat.parse("2010-07-16")));
            films.add(new Film(8L, "The Dark Knight", "Action", "Christopher Nolan", dateFormat.parse("2008-07-18")));
            films.add(new Film(9L, "Interstellar", "Sci-Fi", "Christopher Nolan", dateFormat.parse("2014-11-07")));

            // Agregar películas de Steven Spielberg
            films.add(new Film(10L, "E.T. the Extra-Terrestrial", "Sci-Fi", "Steven Spielberg", dateFormat.parse("1982-06-11")));
            films.add(new Film(11L, "Jurassic Park", "Adventure", "Steven Spielberg", dateFormat.parse("1993-06-11")));
            films.add(new Film(12L, "Schindler's List", "Biography", "Steven Spielberg", dateFormat.parse("1993-12-15")));

            // Agregar películas de David Fincher
            films.add(new Film(13L, "Fight Club", "Drama", "David Fincher", dateFormat.parse("1999-10-15")));
            films.add(new Film(14L, "The Social Network", "Drama", "David Fincher", dateFormat.parse("2010-10-01")));
            films.add(new Film(15L, "Gone Girl", "Mystery", "David Fincher", dateFormat.parse("2014-10-03")));

            // Agregar películas de Stanley Kubrick
            films.add(new Film(16L, "2001: A Space Odyssey", "Sci-Fi", "Stanley Kubrick", dateFormat.parse("1968-04-02")));
            films.add(new Film(17L, "The Shining", "Horror", "Stanley Kubrick", dateFormat.parse("1980-05-23")));
            films.add(new Film(18L, "A Clockwork Orange", "Crime", "Stanley Kubrick", dateFormat.parse("1971-12-19")));

            // Agregar películas de Alfred Hitchcock
            films.add(new Film(19L, "Psycho", "Horror", "Alfred Hitchcock", dateFormat.parse("1960-06-16")));
            films.add(new Film(20L, "Vertigo", "Mystery", "Alfred Hitchcock", dateFormat.parse("1958-05-09")));
            films.add(new Film(21L, "Rear Window", "Mystery", "Alfred Hitchcock", dateFormat.parse("1954-09-01")));

            // Agregar películas de Francis Ford Coppola
            films.add(new Film(22L, "The Godfather", "Crime", "Francis Ford Coppola", dateFormat.parse("1972-03-24")));
            films.add(new Film(23L, "Apocalypse Now", "War", "Francis Ford Coppola", dateFormat.parse("1979-08-15")));
            films.add(new Film(24L, "The Godfather: Part II", "Crime", "Francis Ford Coppola", dateFormat.parse("1974-12-12")));

            // Agregar películas de Sergio Leone
            films.add(new Film(25L, "The Good, the Bad and the Ugly", "Western", "Sergio Leone", dateFormat.parse("1966-12-23")));
            films.add(new Film(26L, "Once Upon a Time in the West", "Western", "Sergio Leone", dateFormat.parse("1968-12-21")));
            films.add(new Film(27L, "A Fistful of Dollars", "Western", "Sergio Leone", dateFormat.parse("1964-09-12")));

            // Agregar películas de Akira Kurosawa
            films.add(new Film(28L, "Seven Samurai", "Adventure", "Akira Kurosawa", dateFormat.parse("1954-04-26")));
            films.add(new Film(29L, "Rashomon", "Crime", "Akira Kurosawa", dateFormat.parse("1950-08-25")));
            films.add(new Film(30L, "Yojimbo", "Action", "Akira Kurosawa", dateFormat.parse("1961-04-25")));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public List<Film> getAllFilms() {
        return films;
    }
    public Film getFilmById(Long id) {
        return films.stream().filter(film -> film.getId().equals(id)).findFirst().orElse(null);
    }
    public List<Film> getFilmsByDirector(String director){
        return  films.stream()
                .filter(film -> film.getDirector().equals(director))
                .collect(Collectors.toList());
    }
    public void addFilm(Film film){films.add(film);}

    public void deleteFilmById(Long id) {
        films.removeIf(film -> film.getId().equals(id));
    }

    public void updateFilm(Film film){
        deleteFilmById(film.getId());
        addFilm(film);
    }
}
