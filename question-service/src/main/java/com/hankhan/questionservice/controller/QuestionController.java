/*
 * Project name: quizapp
 * Date: May 21, 2024
 */

package com.hankhan.questionservice.controller;


import com.hankhan.questionservice.dto.QuestionDto;
import com.hankhan.questionservice.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Todo: What does this class do...
 *
 * @author Shu-Han Han
 * @version 1.0
 * @since 20.0.1
 */
@RestController
@RequestMapping("questions")
@AllArgsConstructor
public class QuestionController {

    private QuestionService questionService;

    @GetMapping
    public ResponseEntity<List<QuestionDto>> getAllQuestions() {
        return ResponseEntity.ok(questionService.findAll());
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<QuestionDto> getQuestionById(@PathVariable int id) {
        return ResponseEntity.ok(questionService.findById(id));
    }

    @GetMapping("difficultyLevel/{id}")
    public ResponseEntity<List<QuestionDto>> getQuestionsByDifficultyLevelId(@PathVariable int id) {
        return ResponseEntity.ok(questionService.findAllByDifficultyLevelId(id));
    }

}