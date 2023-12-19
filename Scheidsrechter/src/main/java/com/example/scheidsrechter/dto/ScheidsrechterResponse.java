package com.example.scheidsrechter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScheidsrechterResponse {
    private String skuCode;
    private String naam;
    private String niveau;
    private Boolean isAssistent;
}