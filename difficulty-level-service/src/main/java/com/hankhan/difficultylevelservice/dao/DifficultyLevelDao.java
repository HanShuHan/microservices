package com.hankhan.difficultylevelservice.dao;

import com.hankhan.difficultylevelservice.model.DifficultyLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DifficultyLevelDao extends JpaRepository<DifficultyLevel, Integer> {

    @Query(value = "SELECT * FROM difficulty_level LIMIT :num", nativeQuery = true)
    List<DifficultyLevel> findAllByLimit(int num);

    @Query(value = "SELECT * FROM difficulty_level ORDER BY RAND() LIMIT :num", nativeQuery = true)
    List<DifficultyLevel> findAllByRandomByLimit(int num);
}