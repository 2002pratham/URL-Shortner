package com.igreaper.url_shortner.exceptions.handler;


import com.igreaper.url_shortner.exceptions.UrlNotFoundException;
import com.igreaper.url_shortner.exceptions.model.UrlShortnerError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class UrlShortnerExceptionHandler {
    @ExceptionHandler(UrlNotFoundException.class)
    public ResponseEntity<UrlShortnerError> handleUrlNotFound(UrlNotFoundException ex){
        UrlShortnerError errorResponse = UrlShortnerError.builder()
                .timestamp(LocalDateTime.now())
                .code(HttpStatus.NOT_FOUND.value())
                .status(HttpStatus.NOT_FOUND.name())
                .errors(List.of(ex.getMessage()))
                .build();
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }
}
