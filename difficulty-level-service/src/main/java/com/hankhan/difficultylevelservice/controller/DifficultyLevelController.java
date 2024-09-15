/*
 * Project name: difficulty-level-service
 * Date: May 24, 2024
 */

package com.hankhan.difficultylevelservice.controller;


import com.hankhan.difficultylevelservice.dto.DifficultyLevelDto;
import com.hankhan.difficultylevelservice.service.DifficultyLevelService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Todo: What does this class do...
 *
 * @author Shu-Han Han
 * @version 1.0
 * @since 20.0.1
 */
@RestController
@RequestMapping("difficulty-levels")
@AllArgsConstructor
public class DifficultyLevelController {

    private DifficultyLevelService difficultyLevelService;

    @GetMapping
    public ResponseEntity<List<DifficultyLevelDto>> getDifficultyLevelsBy(
            @RequestParam(required = false, defaultValue = "false") boolean random,
            @RequestParam(required = false) Integer num
    ) {
        return ResponseEntity.ok(difficultyLevelService.findAllByParams(random, num));
    }

    @GetMapping("count")
    public ResponseEntity<Long> countDifficultyLevels() {
        return ResponseEntity.ok(difficultyLevelService.count());
    }

    @GetMapping("{id}")
    public ResponseEntity<DifficultyLevelDto> getDifficultyLevelById(@PathVariable int id) {
        return ResponseEntity.ok(difficultyLevelService.findById(id));
    }

}