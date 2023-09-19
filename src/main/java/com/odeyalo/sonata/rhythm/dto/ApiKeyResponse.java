package com.odeyalo.sonata.rhythm.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * Dto to return the generated api key 
 */
@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApiKeyResponse {
    String keyValue;
}
