package com.upc.tripbundle.interfaces;

import com.upc.tripbundle.entities.Departamento;

import java.util.List;

public interface DepartamentoService {
    public List<Departamento> obtenerDepartamentos();
    public Departamento insertarDepartamento(Departamento departamento);
    public Departamento actualizarDepartamento(Departamento departamento);
    public void eliminarDepartamento(Integer id);
}
