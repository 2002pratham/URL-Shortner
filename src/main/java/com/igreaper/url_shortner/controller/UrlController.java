package com.igreaper.url_shortner.controller;


import com.igreaper.url_shortner.domain.dto.url.UrlRequestDTO;
import com.igreaper.url_shortner.domain.dto.url.UrlResponseDTO;
import com.igreaper.url_shortner.service.UrlService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UrlController {
    private final UrlService urlService;

    @PostMapping("/shorten-url")
    public ResponseEntity<UrlResponseDTO> shortenUrl(@RequestBody UrlRequestDTO data, HttpServletRequest request){
        return ResponseEntity.ok(urlService.shortenUrl(data,request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Void> redirect(@PathVariable("id") String id){
        HttpHeaders headers = urlService.redirect(id);
        return ResponseEntity.status(HttpStatus.FOUND).headers(headers).build();
    }
}
