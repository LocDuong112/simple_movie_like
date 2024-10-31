package com.example.simplemovielike.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.simplemovielike.entity.LikeMovie;
import com.example.simplemovielike.entity.Movie;
import com.example.simplemovielike.entity.MovieUser;
import com.example.simplemovielike.repository.LikeRepository;
import com.example.simplemovielike.repository.MovieRepository;
import com.example.simplemovielike.repository.MovieUserRepository;
import com.example.simplemovielike.service.LikeService;

@Service
public class LikeServiceImpl implements LikeService{
    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private MovieRepository movieRepository;


    @Override
    public synchronized LikeMovie userLikeMovie(Long userId, Long movieId) throws Exception {
        // Increase counter in Movie
        Optional<Movie> optionalMovie = movieRepository.findById(movieId);
        Movie movieInSystem = new Movie();
        if (optionalMovie.isPresent())
        {
            movieInSystem = optionalMovie.get();
            movieInSystem.setLikeCounter(movieInSystem.getLikeCounter() + 1);
        }
        else 
        {
            throw new Exception("Movie not found!");
        }

        // Save a like
        LikeMovie newLikeMovie = new LikeMovie();
        newLikeMovie.setDeleted(false);
        newLikeMovie.setUserId(userId);
        newLikeMovie.setMovieId(movieId);
        newLikeMovie = likeRepository.save(newLikeMovie);

        // return a likeMovie
        return newLikeMovie;
    }
    
}
