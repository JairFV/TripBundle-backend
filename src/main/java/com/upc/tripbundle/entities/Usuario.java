package com.upc.tripbundle.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 30)
    @NotNull
    @Column(name = "dni", nullable = false, length = 30)
    private String dni;

    @Size(max = 50)
    @NotNull
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Size(max = 50)
    @NotNull
    @Column(name = "apellido", nullable = false, length = 50)
    private String apellido;

    @NotNull
    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Size(max = 30)
    @NotNull
    @Column(name = "telefono", nullable = false, length = 30)
    private String telefono;

    @Size(max = 50)
    @NotNull
    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Size(max = 100)
    @NotNull
    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @Size(max = 50)
    @NotNull
    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Size(max = 30)
    @NotNull
    @Column(name = "rol", nullable = false, length = 30)
    private String rol;

    @OneToMany(mappedBy = "usuario")
    private Set<Reserva> reservas = new LinkedHashSet<>();

}