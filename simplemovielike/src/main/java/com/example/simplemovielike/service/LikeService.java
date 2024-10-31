package com.example.simplemovielike.service;

import com.example.simplemovielike.entity.LikeMovie;

public interface LikeService {
    LikeMovie userLikeMovie(Long userId, Long movieId) throws Exception;
}
