package com.example.simplemovielike.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.simplemovielike.entity.Rating;

@Repository
public interface RatingRepository extends CrudRepository<Rating, Long> {
    
}
