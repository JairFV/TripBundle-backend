package com.upc.tripbundle.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "paquete")
public class Paquete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "categoria", nullable = false, length = 50)
    private String categoria;

    @Size(max = 100)
    @NotNull
    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;

    @Size(max = 50)
    @NotNull
    @Column(name = "alojamiento", nullable = false, length = 50)
    private String alojamiento;

    @Size(max = 50)
    @NotNull
    @Column(name = "transporte", nullable = false, length = 50)
    private String transporte;

    @NotNull
    @Column(name = "valoracion", nullable = false)
    private Integer valoracion;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "atractivoturistico_id", nullable = false)
    private Atractivoturistico atractivoturistico;

    @OneToMany(mappedBy = "paquete")
    private Set<Reserva> reservas = new LinkedHashSet<>();

}