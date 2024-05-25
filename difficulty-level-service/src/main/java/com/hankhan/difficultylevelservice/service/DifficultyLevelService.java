/*
 * Project name: difficulty-level-service
 * Date: May 24, 2024
 */

package com.hankhan.difficultylevelservice.service;


import com.hankhan.difficultylevelservice.dto.DifficultyLevelDto;

import java.util.List;


/**
 * Todo: What does this class do...
 *
 * @author Shu-Han Han
 * @version 1.0
 * @since 20.0.1
 */
public interface DifficultyLevelService {

    List<DifficultyLevelDto> findAllByParams(boolean random, Integer num);

    long count();

    DifficultyLevelDto findById(int id);

}