package com.odeyalo.sonata.rhythm.api;

import com.odeyalo.sonata.rhythm.dto.GeneratedApiKeyResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;
import testing.asserts.GeneratedApiKeyResponseAssert;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@SpringBootTest
@AutoConfigureWebTestClient
@ActiveProfiles("test")
public class CreateApikeyEndpointTest {
    @Autowired
    WebTestClient webTestClient;

    @Test
    void shouldReturn200Status() {
        WebTestClient.ResponseSpec responseSpec = sendRequest();

        responseSpec.expectStatus().isOk();
    }

    @Test
    void shouldReturnApplicationJson() {
        WebTestClient.ResponseSpec responseSpec = sendRequest();

        responseSpec.expectHeader().contentType(APPLICATION_JSON);
    }

    @Test
    void shouldReturnApiKeyInResponseBody() {
        WebTestClient.ResponseSpec responseSpec = sendRequest();

        GeneratedApiKeyResponse responseBody = responseSpec.expectBody(GeneratedApiKeyResponse.class).returnResult().getResponseBody();

        GeneratedApiKeyResponseAssert.fromBody(responseBody).apiKey().isNotNull();
    }

    @Test
    void shouldReturnApiKeyWithPrefixInBody() {
        WebTestClient.ResponseSpec responseSpec = sendRequest();

        GeneratedApiKeyResponse responseBody = responseSpec.expectBody(GeneratedApiKeyResponse.class).returnResult().getResponseBody();

        GeneratedApiKeyResponseAssert.fromBody(responseBody).apiKey().prefix().isSonata();
    }

    private WebTestClient.ResponseSpec sendRequest() {
        return webTestClient.post()
                .uri("/credentials/api-key/generate")
                .exchange();
    }
}