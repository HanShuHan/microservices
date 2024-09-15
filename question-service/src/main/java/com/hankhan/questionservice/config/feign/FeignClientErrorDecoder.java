/*
 * Project name: Microservices
 * Date: September 15, 2024
 */

package com.hankhan.questionservice.config.feign;


import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

/**
 * Todo: What does this class do...
 *
 * @author Shu-Han Han
 * @version 1.0
 * @since 20.0.1
 */
@Component
public class FeignClientErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        if (!String.valueOf(response.status()).startsWith("2")) {
            // Handle 404 specifically
            return new ResponseStatusException(HttpStatus.valueOf(response.status()), "FeignClientError");
        }
        // Handle other HTTP errors as needed
        return new Default().decode(methodKey, response);
    }
}