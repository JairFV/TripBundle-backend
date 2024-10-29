package com.upc.tripbundle.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AtractivoDTO {
    private Integer id;
    private String nombre;
    private String descripcion;
    private Integer valoracion;
    private Integer idDepartamento;
}
