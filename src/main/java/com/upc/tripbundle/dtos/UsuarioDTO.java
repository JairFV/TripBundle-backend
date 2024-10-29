package com.upc.tripbundle.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private Integer id;
    private String dni;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String username;
    private String password;
    private LocalDate fechaNacimiento;
    private String rol;
    //private Set<Reserva> reservas = new LinkedHashSet<>();
}
