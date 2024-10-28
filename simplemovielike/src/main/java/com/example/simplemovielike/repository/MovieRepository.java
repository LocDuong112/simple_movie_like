package com.example.simplemovielike.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.simplemovielike.entity.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {
    
}
