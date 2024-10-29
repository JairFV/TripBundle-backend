package com.upc.tripbundle.interfaces;

import com.upc.tripbundle.dtos.PlatotipicoDTO;
import com.upc.tripbundle.entities.Platotipico;

import java.util.List;

public interface PlatotipicoService {
    public List<Platotipico> obtenerPlatos();
    public Platotipico insertarPlato(PlatotipicoDTO platotipicoDTO, Platotipico platotipico);
    public Platotipico actualizarPlato(Platotipico platotipico);
    public void eliminarPlato(Integer id);
    public List<String[]> obtenerPlatoDescripcion(String nombre);
}
