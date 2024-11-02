package com.example.simplemovielike.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.simplemovielike.entity.LikeMovie;

import jakarta.transaction.Transactional;


@Repository
public interface LikeRepository extends CrudRepository<LikeMovie, Long> {

    @Query("Select l from LikeMovie l where l.userId = :userId and l.movieId = :movieId and l.deleted = false")
    List<LikeMovie> findByUserIdandMovieIdandNotDeleted(@Param("userId") Long userId, @Param("movieId") Long movieId);

    @Query("Select l from LikeMovie l where l.userId = :userId and l.movieId = :movieId")
    List<LikeMovie> findByUserIdandMovieId(@Param("userId") Long userId, @Param("movieId") Long movieId);

    @Modifying
    @Transactional
    @Query("UPDATE LikeMovie l SET l.deleted = true WHERE l.likeId = :likeId AND l.deleted = false")
    void updateDeletedLike(@Param("likeId") Long likeId);
}
