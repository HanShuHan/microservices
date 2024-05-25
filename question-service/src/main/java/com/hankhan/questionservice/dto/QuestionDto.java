package com.hankhan.questionservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.hankhan.questionservice.model.Question}
 */
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionDto implements Serializable {

    int id;

    String title;

    String option1;

    String option2;

    String option3;

    String option4;

    String difficultyLevel;
}