package com.hankhan.difficultylevelservice.model;

import jakarta.persistence.*;
import lombok.*;

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "difficulty_level", uniqueConstraints = {
        @UniqueConstraint(name = "uc_difficultylevel_level", columnNames = {"level"})
})
public class DifficultyLevel extends BaseEntity {

    @Column(name = "level", nullable = false, unique = true)
    @NonNull
    private String level;

    @Version
    @Column(name = "version")
    private Integer version;

}