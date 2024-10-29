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
public class AdministradorDTO {

    private Integer id;
    private String codigo;
    private String nombre;
    private String apellido;
    private String email;
    private String username;
    private String password;
    private String rol;

}
