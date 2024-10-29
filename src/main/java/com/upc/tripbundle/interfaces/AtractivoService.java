package com.upc.tripbundle.interfaces;

import com.upc.tripbundle.dtos.AtractivoDTO;
import com.upc.tripbundle.entities.Atractivoturistico;

import java.util.List;

public interface AtractivoService {
    public List<Atractivoturistico> obtenerAtractivo();
    public Atractivoturistico insertarAtractivo(AtractivoDTO atractivoDTO, Atractivoturistico atractivo);
    public Atractivoturistico actualizarAtractivo(Atractivoturistico atractivo);
    public void eliminarAtractivo(Integer id);
    public List<String[]> AtrativoPorCantiddadPersonasVisitadas();
    public List<String[]> MejoresAtrativos();
}
