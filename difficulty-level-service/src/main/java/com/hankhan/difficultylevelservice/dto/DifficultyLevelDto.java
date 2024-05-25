/*
 * Project name: difficulty-level-service
 * Date: May 24, 2024
 */

package com.hankhan.difficultylevelservice.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hankhan.difficultylevelservice.model.DifficultyLevel;
import lombok.Value;

import java.io.Serializable;


/**
 * Dto for {@link DifficultyLevel}
 *
 * @author Shu-Han Han
 * @version 1.0
 * @since 20.0.1
 */
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class DifficultyLevelDto implements Serializable {

    int id;

    String level;

}