package com.danilo.realEstateSystem.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Anuncio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "imovel_id", nullable = false, unique = true)
    private Imovel imovel;

    @ManyToMany
    @JoinTable(
            name = "anuncio_corretor",
            joinColumns = @JoinColumn(name = "anuncio_id"),
            inverseJoinColumns = @JoinColumn(name = "corretor_id")
    )
    private Set<Corretor> corretor;
}
