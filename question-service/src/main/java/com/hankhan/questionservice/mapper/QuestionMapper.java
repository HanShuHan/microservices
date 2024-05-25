package com.hankhan.questionservice.mapper;

import com.hankhan.questionservice.dto.QuestionDto;
import com.hankhan.questionservice.feign.DifficultyLevelInterface;
import com.hankhan.questionservice.model.Question;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface QuestionMapper {

    @Mapping(source = "difficultyLevel", target = "difficultyLevel", qualifiedByName = "idToString")
    QuestionDto toDto(Question question, @Context DifficultyLevelInterface difficultyLevelInterface);

    @Mapping(source = "difficultyLevel", target = "difficultyLevel", qualifiedByName = "idToStringWithGivenLevel")
    QuestionDto toDto(Question question, @Context String level);

    List<QuestionDto> toDtos(List<Question> questions, @Context DifficultyLevelInterface difficultyLevelInterface);

    List<QuestionDto> toDtos(List<Question> questions, @Context String level);

    @Named("idToString")
    default String idToString(Integer difficultyLevel, @Context DifficultyLevelInterface difficultyLevelInterface) {
        return difficultyLevelInterface.getDifficultyLevelById(difficultyLevel).getBody().getLevel();
    }

    @Named("idToStringWithGivenLevel")
    default String idToStringWithGivenLevel(Integer difficultyLevel, @Context String level) {
        return level;
    }
}