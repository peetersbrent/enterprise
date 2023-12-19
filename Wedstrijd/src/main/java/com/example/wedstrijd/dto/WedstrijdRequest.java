package com.example.wedstrijd.dto;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WedstrijdRequest {

    private String skuCode;
    private String thuisTeam;
    private String uitTeam;
    private Date datum;
    private Long ScheidsrechterID;
    private String score;
}
