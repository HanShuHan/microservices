/*
 * Project name: quizapp
 * Date: May 21, 2024
 */

package com.hankhan.questionservice.config;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Todo: What does this class do...
 *
 * @author Shu-Han Han
 * @version 1.0
 * @since 20.0.1
 */
@Configuration
public class AppConfig {

    @Bean
    public Faker faker() {
        return new Faker();
    }

}
