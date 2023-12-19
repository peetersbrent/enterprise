package com.example.scheidsrechter.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "scheidsrechter")
public class Scheidsrechter {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long scheidsrechterID;
    private String skuCode;
    private String naam;
    private Date geboortedatum;
    private String mail;
    private String niveau;
    private Boolean isAssistent;
}
