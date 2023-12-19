package com.example.wedstrijd.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WedstrijdResponse {
    private String skuCode;
    private String thuisTeam;
    private String uitTeam;
    private Date datum;
    private Long ScheidsrechterID;
    private String score;

}
