package com.upc.tripbundle.interfaces;

import com.upc.tripbundle.dtos.BoletaDTO;
import com.upc.tripbundle.entities.Boleta;

import java.util.List;

public interface BoletaService {
    public List<Boleta> obtenerBoletas();
    public Boleta insertarBoleta(BoletaDTO boletaDto, Boleta boleta);
    public Boleta actualizarBoleta(Boleta boleta);
    public void eliminarBoleta(Integer id);
    public List<String[]> obtenerBoletaPorUsuario(Integer id);
}
