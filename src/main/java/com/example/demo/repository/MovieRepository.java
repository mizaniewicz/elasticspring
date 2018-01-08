package com.example.demo.repository;

import com.example.demo.model.Director;
import com.example.demo.model.Movie;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends ElasticsearchRepository<Movie, Long> {

    List<Movie> findAll();

    List<Movie> findByName(String name);

    List<Movie> findByRatingBetween(Double start, Double end);

    List<Movie> findByDirector(Director director);
}
