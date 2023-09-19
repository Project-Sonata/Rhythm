package com.odeyalo.sonata.rhythm.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * Dto that contains generated api key to return
 */
@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GeneratedApiKeyResponse {
    ApiKeyResponse apiKey;
}
