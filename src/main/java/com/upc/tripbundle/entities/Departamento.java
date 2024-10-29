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
@Table(name = "departamento")
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Size(max = 100)
    @NotNull
    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;

    @OneToMany(mappedBy = "departamento")
    private Set<Atractivoturistico> atractivoturisticos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "departamento")
    private Set<Fauna> faunas = new LinkedHashSet<>();

    @OneToMany(mappedBy = "departamento")
    private Set<Flora> floras = new LinkedHashSet<>();

    @OneToMany(mappedBy = "departamento")
    private Set<Platotipico> platotipicos = new LinkedHashSet<>();

}