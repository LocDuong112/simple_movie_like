package com.example.simplemovielike.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.simplemovielike.entity.LikeMovie;

@Repository
public interface LikeRepository extends CrudRepository<LikeMovie, Long> {
    
}
