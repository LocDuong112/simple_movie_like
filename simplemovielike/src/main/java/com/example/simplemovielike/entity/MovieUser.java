package com.example.simplemovielike.entity;

import java.util.List;

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
public class MovieUser {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long movieUserId;
    String username;
    List<String> likedMovie;

}
