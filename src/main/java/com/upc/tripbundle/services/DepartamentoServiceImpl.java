package com.upc.tripbundle.services;

import com.upc.tripbundle.entities.Departamento;
import com.upc.tripbundle.repositories.DepartamentoRepository;
import com.upc.tripbundle.interfaces.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {
    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Override
    public List<Departamento> obtenerDepartamentos() {
        return departamentoRepository.findAll();
    }

    @Override
    public Departamento insertarDepartamento(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    @Override
    public Departamento actualizarDepartamento(Departamento departamento) {
        if(departamentoRepository.findById(departamento.getId()).isPresent())
            return departamentoRepository.save(departamento);
        return null;
    }

    @Override
    public void eliminarDepartamento(Integer id) {
        if(departamentoRepository.findById(id).isPresent())
            departamentoRepository.deleteById(id);
    }
}
