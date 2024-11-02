package com.example.simplemovielike.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.simplemovielike.entity.LikeMovie;
import com.example.simplemovielike.service.LikeService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/like-movie")
public class LikeController {
    @Autowired
    private LikeService likeService;

    @PostMapping("")
    public ResponseEntity<LikeMovie> userLikeMovie(@RequestBody Map<String, Long> requestBody) throws Exception {
        Long userId = requestBody.get("userId");
        Long movieId = requestBody.get("movieId");
        LikeMovie likeMovie = likeService.userLikeMovie(userId, movieId);
        
        return new ResponseEntity<>(likeMovie, HttpStatus.OK);
    }

    @PostMapping("/unlike")
    public ResponseEntity<LikeMovie> userUnlikeMovie(@RequestBody Map<String, Long> requestBody) throws Exception {
        Long userId = requestBody.get("userId");
        Long movieId = requestBody.get("movieId");
        LikeMovie likeMovie = likeService.userUnlikeMovie(userId, movieId);

        if (likeMovie.equals(new LikeMovie()))
        {
            return new ResponseEntity<>(likeMovie, HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<>(likeMovie, HttpStatus.OK);
    }
    
}
