package com.example.simplemovielike.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.simplemovielike.entity.LikeMovie;
import com.example.simplemovielike.entity.Movie;
import com.example.simplemovielike.repository.LikeRepository;
import com.example.simplemovielike.repository.MovieRepository;
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
        List<LikeMovie> listNewLikeMovie = likeRepository.findByUserIdandMovieId(userId, movieId);
        if (listNewLikeMovie.size() != 0)
        {
            newLikeMovie = listNewLikeMovie.get(0);
            newLikeMovie.setDeleted(false);
            newLikeMovie = likeRepository.save(newLikeMovie);
        }
        else
        {
            newLikeMovie.setDeleted(false);
            newLikeMovie.setUserId(userId);
            newLikeMovie.setMovieId(movieId);
            newLikeMovie = likeRepository.save(newLikeMovie);
        }

        // return a likeMovie
        return newLikeMovie;
    }


    @Override
    public synchronized LikeMovie userUnlikeMovie(Long userId, Long movieId) throws Exception {
        // Decrease like counter 
        Optional<Movie> optionalMovie = movieRepository.findById(movieId);
        Movie movieInSystem = new Movie();
        if (optionalMovie.isPresent())
        {
            movieInSystem = optionalMovie.get();
            movieInSystem.setLikeCounter(movieInSystem.getLikeCounter() - 1);
        }
        else 
        {
            throw new Exception("Movie not found!");
        }

        // update a like to deleted
        LikeMovie newLikeMovie = new LikeMovie();
        List<LikeMovie> listNewLikeMovie = likeRepository.findByUserIdandMovieIdandNotDeleted(userId, movieId);
        if (listNewLikeMovie.size() != 0)
        {
            Long likeId = listNewLikeMovie.get(0).getLikeId();
            likeRepository.updateDeletedLike(likeId);
            if (likeRepository.findById(likeId).isPresent())
            {
                newLikeMovie = likeRepository.findById(likeId).get();
            }
        }

        return newLikeMovie;
    }
    
}
