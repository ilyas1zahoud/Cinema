package com.ilem.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20)
    private String nomClient;
    private Double prix;
    @Column(unique = true)
    private int codePayement;
    private Boolean reserve;
 @ManyToOne
 private Place place;
@ManyToOne
 private Projection projection;
}
