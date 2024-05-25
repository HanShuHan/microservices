/*
 * Project name: quizapp
 * Date: May 21, 2024
 */

package com.hankhan.questionservice.service;


import com.hankhan.questionservice.dto.QuestionDto;

import java.util.List;


/**
 * Todo: What does this class do...
 *
 * @author Shu-Han Han
 * @version 1.0
 * @since 20.0.1
 */
public interface QuestionService {

    List<QuestionDto> findAll();

    QuestionDto findById(int id);

    List<QuestionDto> findAllByDifficultyLevelId(int id);

}
