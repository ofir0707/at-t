package com.att.tdp.popcorn_palace.service;

import com.att.tdp.popcorn_palace.model.Movie;
import com.att.tdp.popcorn_palace.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    // מתודולוגיית מחיקה לפי שם הסרט
    public void deleteMovieByTitle(String title) {
        Movie movie = movieRepository.findByTitle(title); // חיפוש סרט לפי שם
        if (movie != null) {
            movieRepository.delete(movie);  // מחיקה של הסרט שנמצא
        }
    }

    // מתודולוגיית עדכון לפי שם הסרט
    public Movie updateMovieByTitle(String title, Movie movie) {
        Movie existingMovie = movieRepository.findByTitle(title); // חיפוש הסרט לפי שם
        if (existingMovie != null) {
            existingMovie.setTitle(movie.getTitle());  // עדכון שם הסרט (אם השתנה)
            existingMovie.setGenre(movie.getGenre());  // עדכון ז'אנר הסרט
            existingMovie.setDuration(movie.getDuration());  // עדכון משך הזמן של הסרט
            existingMovie.setRating(movie.getRating());  // עדכון דירוג הסרט
            existingMovie.setReleaseYear(movie.getReleaseYear());  // עדכון שנת יציאת הסרט
            return movieRepository.save(existingMovie);  // שמירה של הסרט המעודכן
        }
        return null;  // אם הסרט לא נמצא
    }
}
