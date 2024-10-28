package com.example.simplemovielike.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long ratingId;
    int rating;
    Long likeId;
    Long userId;
    Long movieId;
    boolean deleted;

}
