package com.example.competitie.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document("competitie")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Competitie {
    @Id
    private String competitieId;
    private String skuCode;
    private String provincie;
    private List<String> ploegen;
    private Date startDatum;
    private Date eindDatum;
    private String competitieleider;
}
