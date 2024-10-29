package com.upc.tripbundle.interfaces;

import com.upc.tripbundle.entities.Administrador;

import java.util.List;

public interface AdministradorService {

    public Administrador buscarAdministrador(Integer id);
    public List<Administrador> buscarAdministrador();
    public Administrador insertarAdministrador(Administrador administrador);
    public Administrador actualizarAdministrador(Administrador administrador);
    public void eliminarAdministrador(Integer id);
}
