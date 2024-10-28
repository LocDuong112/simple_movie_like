package com.example.simplemovielike.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.simplemovielike.entity.MovieUser;

@Repository
public interface MovieUserRepository extends CrudRepository<MovieUser, Long> {
    
}
