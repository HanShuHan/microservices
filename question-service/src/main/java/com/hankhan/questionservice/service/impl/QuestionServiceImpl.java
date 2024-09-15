/*
 * Project name: quizapp
 * Date: May 21, 2024
 */

package com.hankhan.questionservice.service.impl;

import com.hankhan.questionservice.dao.QuestionDao;
import com.hankhan.questionservice.dto.QuestionDto;
import com.hankhan.questionservice.feign.DifficultyLevelClient;
import com.hankhan.questionservice.mapper.QuestionMapper;
import com.hankhan.questionservice.model.Question;
import com.hankhan.questionservice.service.QuestionService;
import feign.FeignException;
import jakarta.validation.ValidationException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Todo: What does this class do...
 *
 * @author Shu-Han Han
 * @version 1.0
 * @since 20.0.1
 */
@Service
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private QuestionDao questionDao;
    private QuestionMapper questionMapper;
    private DifficultyLevelClient difficultyLevelClient;

    @Override
    public List<QuestionDto> findAll() {
        List<Question> questions = questionDao.findAll();
        if (questions.isEmpty()) return Collections.emptyList();
        return questionMapper.toDtos(questions, difficultyLevelClient);
    }

    @Override
    public QuestionDto findById(int id) {
        Question question = questionDao.findById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("The question is not found by id: %d", id)));
        return questionMapper.toDto(question, difficultyLevelClient);
    }

    @Override
    public List<QuestionDto> findAllByDifficultyLevelId(int id) {
        try {
            String level = difficultyLevelClient.getDifficultyLevelById(id).getBody().getLevel();
            List<Question> questions = questionDao.findAllByDifficultyLevel(id);
            return questionMapper.toDtos(questions, level);
        } catch (FeignException e) {
            throw new ValidationException(String.format("The difficulty level is not found by the given id: %d", id));
        }
    }
}
