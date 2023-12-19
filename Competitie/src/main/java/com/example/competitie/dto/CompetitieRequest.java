package com.example.competitie.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompetitieRequest {
    private String skuCode;
    private String provincie;
    private List<String> ploegen;
    private Date startDatum;
    private Date eindDatum;
    private String competitieleider;
}
