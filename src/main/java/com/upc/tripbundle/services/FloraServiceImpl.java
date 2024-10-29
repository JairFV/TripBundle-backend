package com.upc.tripbundle.services;

import com.upc.tripbundle.dtos.FloraDTO;
import com.upc.tripbundle.entities.Departamento;
import com.upc.tripbundle.entities.Flora;
import com.upc.tripbundle.interfaces.FloraService;
import com.upc.tripbundle.repositories.DepartamentoRepository;
import com.upc.tripbundle.repositories.FloraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FloraServiceImpl implements FloraService {
    @Autowired
    private FloraRepository floraRepository;
    private final DepartamentoRepository departamentoRepository;

    public FloraServiceImpl(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    @Override
    public List<Flora> obtenerFloras() {
        return floraRepository.findAll();
    }

    @Override
    public Flora insertarFlora(FloraDTO floraDTO, Flora flora) {
        Departamento departamento = departamentoRepository.findById(floraDTO.getIdDepartamento()).orElse(null);
        if(departamento!=null){
            flora.setDepartamento(departamento);
            return floraRepository.save(flora);
        }
        return null;
    }

    @Override
    public Flora actualizarFlora(Flora flora) {
        if(floraRepository.findById(flora.getId()).isPresent())
            return floraRepository.save(flora);
        return null;
    }

    @Override
    public void eliminarFlora(Integer id) {
        if(floraRepository.findById(id).isPresent())
            floraRepository.deleteById(id);
    }

    @Override
    public List<String[]> obtenerFloraDescripcion(String nombre) {
        return floraRepository.obtenerFloraDescripcion(nombre);
    }
}
