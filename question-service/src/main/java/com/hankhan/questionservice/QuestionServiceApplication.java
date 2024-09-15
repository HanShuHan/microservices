package com.hankhan.questionservice;

import com.github.javafaker.Faker;
import com.hankhan.questionservice.dao.QuestionDao;
import com.hankhan.questionservice.feign.DifficultyLevelClient;
import com.hankhan.questionservice.model.Question;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.LinkedList;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
@AllArgsConstructor
public class QuestionServiceApplication implements CommandLineRunner {

    private QuestionDao questionDao;
    private DifficultyLevelClient difficultyLevelClient;
    private Faker faker;

    public static void main(String[] args) {
        SpringApplication.run(QuestionServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        populateQuestionTable();
    }

    private void populateQuestionTable() {
        if (questionDao.count() == 0L && difficultyLevelClient.countDifficultyLevels().getBody() > 1L) {
            List<Question> questions = new LinkedList<>();

            for (int i = 0; i < 20; i++) {
                Question question = new Question(
                        "Title" + (i + 1),
                        faker.hobbit().character(),
                        faker.address().cityName(),
                        faker.animal().name(),
                        faker.book().author(),
                        faker.random().nextInt(1, 4),
                        difficultyLevelClient.getDifficultyLevelsBy(true, 1).getBody().get(0).getId()
                );
                questions.add(question);
            }
            questionDao.saveAllAndFlush(questions);
        }
    }

}
