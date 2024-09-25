/*
 * Project name: difficulty-level-service
 * Date: May 24, 2024
 */

package com.hankhan.difficultylevelservice.service.impl;


import com.hankhan.difficultylevelservice.dao.DifficultyLevelDao;
import com.hankhan.difficultylevelservice.dto.DifficultyLevelDto;
import com.hankhan.difficultylevelservice.mapper.DifficultyLevelMapper;
import com.hankhan.difficultylevelservice.model.DifficultyLevel;
import com.hankhan.difficultylevelservice.service.DifficultyLevelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
public class DifficultyLevelServiceImpl implements DifficultyLevelService {

    private DifficultyLevelDao difficultylevelDao;
    private DifficultyLevelMapper difficultyLevelMapper;

    @Override
    public List<DifficultyLevelDto> findAllByParams(boolean random, Integer num) {
        if (num != null && num < 1) {
            throw new IllegalArgumentException("The fetch quantity cannot be less than 1");
        }

        List<DifficultyLevel> difficultyLevels;
        if (num == null) num = Integer.MAX_VALUE;
        if (random) {
            difficultyLevels = difficultylevelDao.findAllByRandomByLimit(num);
        } else {
            difficultyLevels = difficultylevelDao.findAllByLimit(num);
        }
        return difficultyLevelMapper.toDtos(difficultyLevels);
    }

    @Override
    public long count() {
        return difficultylevelDao.count();
    }

    @Override
    public DifficultyLevelDto findById(int id) {
        DifficultyLevel difficultyLevel = difficultylevelDao.findById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("Cannot find the difficulty level by id: %d", id)));
        return difficultyLevelMapper.toDto(difficultyLevel);
    }
}
