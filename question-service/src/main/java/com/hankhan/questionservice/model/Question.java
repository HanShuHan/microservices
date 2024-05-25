package com.hankhan.questionservice.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "question", indexes = {
        @Index(name = "idx_question_difficulty_level", columnList = "difficulty_level")
}, uniqueConstraints = {
        @UniqueConstraint(name = "uc_question_title", columnNames = {"title"})
})
public class Question extends BaseEntity {

    @Column(name = "title", nullable = false, unique = true)
    @NonNull
    private String title;

    @Column(name = "option_1", nullable = false)
    @NonNull
    private String option1;

    @Column(name = "option_2", nullable = false)
    @NonNull
    private String option2;

    @Column(name = "option_3", nullable = false)
    @NonNull
    private String option3;

    @Column(name = "option_4", nullable = false)
    @NonNull
    private String option4;

    @Column(name = "correct_option", nullable = false)
    @NonNull
    private Integer correctOption;

    @Column(name = "difficulty_level", nullable = false)
    @NonNull
    private Integer difficultyLevel;

    @Version
    @Column(name = "version")
    private Integer version;

}