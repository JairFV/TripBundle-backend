package com.upc.tripbundle.interfaces;

import com.upc.tripbundle.dtos.PaqueteDTO;
import com.upc.tripbundle.entities.Paquete;

import java.util.List;

public interface PaqueteService {
    public List<Paquete> obtenerPaquetes();
    public Paquete insertarPaquete(PaqueteDTO paqueteDTO, Paquete paquete);
    public Paquete actualizarPaquete(Paquete paquete);
    public void eliminarPaquete(Integer id);
    public List<String[]> obtenerAlojamientoPorPrecio();
    public List<String[]> paqueteDepartamento(String categoria);
}
