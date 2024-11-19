package com.igreaper.url_shortner.exceptions;

import lombok.Getter;

@Getter
public class UrlNotFoundException extends RuntimeException{
    private final String urlId;
    public UrlNotFoundException(String urlId){
        super(String.format("Url is not found",urlId));
        this.urlId = urlId;
    }
}
