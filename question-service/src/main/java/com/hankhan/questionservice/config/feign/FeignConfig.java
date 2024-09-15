/*
 * Project name: Microservices
 * Date: September 15, 2024
 */

package com.hankhan.questionservice.config.feign;


import feign.codec.ErrorDecoder;
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
public class FeignConfig {

    @Bean
    public ErrorDecoder errorDecoder(FeignClientErrorDecoder errorDecoder) {
        return errorDecoder;
    }
}