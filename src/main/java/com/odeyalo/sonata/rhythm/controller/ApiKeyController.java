package com.odeyalo.sonata.rhythm.controller;

import com.odeyalo.sonata.rhythm.dto.ApiKeyResponse;
import com.odeyalo.sonata.rhythm.dto.GeneratedApiKeyResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.ResponseEntity.ok;
import static reactor.core.publisher.Mono.just;

@RestController
@RequestMapping("/credentials/api-key")
public class ApiKeyController {

    @PostMapping(value = "/generate")
    public Mono<ResponseEntity<?>> createApiKey() {
        GeneratedApiKeyResponse responseBody = GeneratedApiKeyResponse.builder().apiKey(ApiKeyResponse.of("SONATA-value")).build();

        return just(ok().header(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                .body(responseBody)
        );
    }
}
