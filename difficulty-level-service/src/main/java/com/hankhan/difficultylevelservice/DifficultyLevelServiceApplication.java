package com.hankhan.difficultylevelservice;

import com.hankhan.difficultylevelservice.dao.DifficultyLevelDao;
import com.hankhan.difficultylevelservice.model.DifficultyLevel;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@AllArgsConstructor
public class DifficultyLevelServiceApplication implements CommandLineRunner {

    private DifficultyLevelDao difficultyLevelDao;

    public static void main(String[] args) {
        SpringApplication.run(DifficultyLevelServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        populateDifficultyLevelTable();
    }

    private void populateDifficultyLevelTable() {
        if (difficultyLevelDao.count() == 0L) {
            List<DifficultyLevel> difficultyLevels = List.of(
                    new DifficultyLevel("Easy"),
                    new DifficultyLevel("Medium"),
                    new DifficultyLevel("Hard")
            );
            difficultyLevelDao.saveAllAndFlush(difficultyLevels);
        }
    }

}

