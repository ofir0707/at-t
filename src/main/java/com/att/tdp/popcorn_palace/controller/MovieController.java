package com.att.tdp.popcorn_palace.controller;

import com.att.tdp.popcorn_palace.model.Movie;
import com.att.tdp.popcorn_palace.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    // מתודולוגיית GET - לקבל את כל הסרטים
    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    // מתודולוגיית POST - להוסיף סרט חדש
    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }


    // מתודולוגיית DELETE - למחוק סרט לפי שם
    @DeleteMapping("/deleteByTitle")
    public void deleteMovie(@RequestParam String title) {
        movieService.deleteMovieByTitle(title);  // מבצע את פעולת המחיקה לפי שם הסרט
    }

    // מתודולוגיית PUT - לעדכן סרט לפי שם
    @PutMapping("/updateByTitle")
    public Movie updateMovie(@RequestParam String title, @RequestBody Movie movie) {
        return movieService.updateMovieByTitle(title, movie);  // מבצע את פעולת העדכון לפי שם הסרט
    }
}
