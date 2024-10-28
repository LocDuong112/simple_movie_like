package com.example.simplemovielike.repository;

import org.springframework.stereotype.Repository;

import com.example.simplemovielike.entity.Episode;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface EpisodeRepository extends CrudRepository<Episode, Long> {
    
}
