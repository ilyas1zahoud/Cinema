package com.ilem.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor

public class Film {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(length = 50)
private String titre;
private Double duree;
@Column(length = 50)
private String realisateur;
@Column(length = 50)
private String description;
@Column(length = 50)
private String photo;
private Date dateSortie;
@OneToMany(mappedBy = "film")
private Collection<Projection> projections;
@ManyToOne
private   Categorie categorie;
}
