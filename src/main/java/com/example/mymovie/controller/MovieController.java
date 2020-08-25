package com.example.mymovie.controller;

import com.example.mymovie.exception.ResourceNotFoundException;
import com.example.mymovie.model.Movie;
import com.example.mymovie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Rahul Verma.
 */
@RestController
@RequestMapping("/api")
public class MovieController {

    @Autowired
    MovieRepository movieRepository;

    /**
     * Endpoint is used to get list of movies
     */
    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    /**
     * Endpoint is used to create a new movie
     */
    @PostMapping("/movie")
    public Movie createMovie(@Valid @RequestBody Movie movie) {
        return movieRepository.save(movie);
    }


    /**
     * Endpoint is used to get a movie by ID
     */
    @GetMapping("/movies/{id}")
    public Movie getMovieById(@PathVariable(value = "id") Long movieId) {
        return movieRepository.findById(movieId)
                .orElseThrow(() -> new ResourceNotFoundException("Movie", "id", movieId));
    }

    /**
     * Endpoint is used to update a movie on a particular ID
     */
    @PutMapping("/movies/{id}")
    public Movie updateMovie(@PathVariable(value = "id") Long movieId,
                             @Valid @RequestBody Movie movieDetails) {

        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new ResourceNotFoundException("Movie", "id", movieId));

        movie.setTitle(movieDetails.getTitle());
        movie.setCategory(movieDetails.getCategory());
        movie.setRating(movieDetails.getRating());
        Movie updatedMovie = movieRepository.save(movie);
        return updatedMovie;
    }

    /**
     * Endpoint is used to delete a movie on the basis of ID
     */
    @DeleteMapping("/movies/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable(value = "id") Long movieId) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new ResourceNotFoundException("Movie", "id", movieId));

        movieRepository.delete(movie);

        return ResponseEntity.ok().build();
    }
}
