package com.ilem.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Collection;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Cinema implements Serializable {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(length = 50)
private String name;
private Double longitude,latitude,altitude;
private int nombreSalles;
@OneToMany(mappedBy ="cinema")
private Collection<Salle> salles;
@ManyToOne
    private Ville ville;
}
