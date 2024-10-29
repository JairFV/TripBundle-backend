package com.upc.tripbundle.interfaces;

import com.upc.tripbundle.dtos.FaunaDTO;
import com.upc.tripbundle.entities.Fauna;

import java.util.List;

public interface FaunaService {
    public List<Fauna> obtenerFaunas();
    public Fauna insertarFauna(FaunaDTO faunaDTO,Fauna fauna);
    public Fauna actualizarFauna(Fauna fauna);
    public void eliminarFauna(Integer id);
    public List<String[]> obtenerFaunaDescripcion(String nombre);
}
