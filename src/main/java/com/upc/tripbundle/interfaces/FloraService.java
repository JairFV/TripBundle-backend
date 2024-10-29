package com.upc.tripbundle.interfaces;

import com.upc.tripbundle.dtos.FloraDTO;
import com.upc.tripbundle.entities.Flora;

import java.util.List;

public interface FloraService {
    public List<Flora> obtenerFloras();
    public Flora insertarFlora(FloraDTO floraDTO, Flora flora);
    public Flora actualizarFlora(Flora flora);
    public void eliminarFlora(Integer id);
    public List<String[]> obtenerFloraDescripcion(String nombre);
}
