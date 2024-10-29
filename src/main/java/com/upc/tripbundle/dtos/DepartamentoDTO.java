package com.upc.tripbundle.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartamentoDTO {
    private Integer id;
    private String nombre;
    private String descripcion;
   // private Set<Reserva> reservas = new LinkedHashSet<>();
}
