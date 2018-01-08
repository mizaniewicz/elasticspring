package com.example.demo.api;

import com.example.demo.model.Movie;
import com.example.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;

@RestController
public class MovieResource {

    private MovieService movieService;

    @Autowired
    public MovieResource(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/movie/add")
    public ResponseEntity<Movie> addMovie(@RequestBody  Movie newMovie) {
        Movie savedMovie = movieService.addMovie(newMovie);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
                "/{id}").buildAndExpand(savedMovie.getId()).toUri();
        return ResponseEntity.ok(savedMovie).created(location).build();
    }

    @DeleteMapping("/movie/{id}/delete")
    public ResponseEntity<String> deleteMovie(@PathVariable("id") Long movieId) {
        movieService.deleteMovie(movieId);
        return ResponseEntity.ok("Deleted");
    }

    @GetMapping("/movie/get-by-name/{name}")
    public ResponseEntity<List<Movie>> findMovieByName(@PathVariable("name") String movieName) {
        List<Movie> fetchedMovie = movieService.getByName(movieName);
        return ResponseEntity.ok(fetchedMovie);
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> findMovies() {
        List<Movie> fetchedMovie = movieService.getMovies();
        return ResponseEntity.ok(fetchedMovie);
    }
}
