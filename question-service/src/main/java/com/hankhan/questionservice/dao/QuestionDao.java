package com.hankhan.questionservice.dao;

import com.hankhan.questionservice.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer>, JpaSpecificationExecutor<Question> {
    @Query(value = "SELECT * FROM question ORDER BY RAND() LIMIT :num", nativeQuery = true)
    List<Question> findRandom(@Param("num") Integer num);

    List<Question> findAllByDifficultyLevel(int id);

    @Query(value = "SELECT * FROM question q WHERE q.difficulty_level = :difficulty_level_id ORDER BY RAND() LIMIT :num", nativeQuery = true)
    List<Question> findByDifficultyLevelIdByRandomByLimit(@Param("difficulty_level_id") Integer difficulty_level_id, @Param("num") Integer num);
}