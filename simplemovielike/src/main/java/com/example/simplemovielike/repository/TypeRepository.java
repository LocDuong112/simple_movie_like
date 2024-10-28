package com.example.simplemovielike.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.simplemovielike.entity.Type;

@Repository
public interface TypeRepository extends CrudRepository<Type, Long> {
    
}
