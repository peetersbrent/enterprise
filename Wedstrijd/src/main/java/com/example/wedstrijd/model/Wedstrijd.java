package com.example.wedstrijd.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "wedstrijd")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Wedstrijd {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long wedstrijdID;
    private String skuCode;
    private String thuisTeam;
    private String uitTeam;
    private Date datum;
    private Long ScheidsrechterID;
    private String score;
}
