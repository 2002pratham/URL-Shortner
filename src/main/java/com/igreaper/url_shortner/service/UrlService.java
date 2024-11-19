package com.igreaper.url_shortner.service;

import com.igreaper.url_shortner.domain.dto.url.UrlRequestDTO;
import com.igreaper.url_shortner.domain.dto.url.UrlResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;

public interface UrlService {
    UrlResponseDTO shortenUrl(UrlRequestDTO data, HttpServletRequest request);
    HttpHeaders redirect(String id);
}
