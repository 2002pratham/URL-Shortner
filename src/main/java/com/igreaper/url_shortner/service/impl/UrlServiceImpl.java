package com.igreaper.url_shortner.service.impl;

import com.igreaper.url_shortner.domain.dto.url.UrlRequestDTO;
import com.igreaper.url_shortner.domain.dto.url.UrlResponseDTO;
import com.igreaper.url_shortner.entities.UrlEntity;
import com.igreaper.url_shortner.exceptions.UrlNotFoundException;
import com.igreaper.url_shortner.repository.UrlRepository;
import com.igreaper.url_shortner.service.UrlService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.time.LocalDateTime;


@Service
@AllArgsConstructor
public class UrlServiceImpl implements UrlService {

    private final  UrlRepository urlRepository;

    @Override
    public UrlResponseDTO shortenUrl(UrlRequestDTO data, HttpServletRequest request) {
        String id;

        do{
            id = RandomStringUtils.randomAlphanumeric(5,10);
        }while (urlRepository.existsById(id));
urlRepository.save((new UrlEntity(id,data.url(), LocalDateTime.now().plusMinutes(1))));

//(Post) url-shorten request

String redirectUrl = request.getRequestURL().toString().replace("shorten-url",id);
return new UrlResponseDTO(data.url(), redirectUrl);
    }

    @Override
    public HttpHeaders redirect(String id) {
        UrlEntity url = urlRepository.findById(id).orElseThrow(() -> new UrlNotFoundException(id));
        org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
        headers.setLocation(URI.create(url.getUrl()));
        return headers;
    }
}
