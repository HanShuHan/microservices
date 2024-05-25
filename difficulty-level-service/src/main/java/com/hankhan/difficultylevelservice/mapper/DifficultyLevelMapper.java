package com.hankhan.difficultylevelservice.mapper;

import com.hankhan.difficultylevelservice.dto.DifficultyLevelDto;
import com.hankhan.difficultylevelservice.model.DifficultyLevel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper( componentModel = MappingConstants.ComponentModel.SPRING)
public interface DifficultyLevelMapper {

    DifficultyLevelDto toDto(DifficultyLevel difficultyLevel);

    List<DifficultyLevelDto> toDtos(List<DifficultyLevel> difficultyLevel);
}