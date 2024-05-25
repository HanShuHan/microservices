/*
 * Project name: question-service
 * Date: May 24, 2024
 */

package com.hankhan.questionservice.feign;


import com.hankhan.questionservice.dto.DifficultyLevelDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Todo: What does this class do...
 *
 * @author Shu-Han Han
 * @version 1.0
 * @since 20.0.1
 */
@FeignClient(value = "DIFFICULTY-LEVEL-SERVICE", path = "difficulty-levels")
public interface DifficultyLevelInterface {

    @GetMapping
    ResponseEntity<List<DifficultyLevelDto>> getDifficultyLevelsBy(
            @RequestParam(required = false, defaultValue = "false") boolean random,
            @RequestParam(required = false) Integer num
    );

    @GetMapping("count")
    ResponseEntity<Long> countDifficultyLevels();

    @GetMapping("{id}")
    ResponseEntity<DifficultyLevelDto> getDifficultyLevelById(@PathVariable int id);

}