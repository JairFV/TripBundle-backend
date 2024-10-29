package com.upc.tripbundle.services;

import com.upc.tripbundle.dtos.FaunaDTO;
import com.upc.tripbundle.entities.Departamento;
import com.upc.tripbundle.entities.Fauna;
import com.upc.tripbundle.interfaces.FaunaService;
import com.upc.tripbundle.repositories.DepartamentoRepository;
import com.upc.tripbundle.repositories.FaunaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaunaServiceImpl implements FaunaService {
    @Autowired
    private FaunaRepository faunaRepository;
    private final DepartamentoRepository departamentoRepository;

    public FaunaServiceImpl(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    @Override
    public List<Fauna> obtenerFaunas() {
        return faunaRepository.findAll();
    }

    @Override
    public Fauna insertarFauna(FaunaDTO faunaDTO, Fauna fauna) {
        Departamento departamento = departamentoRepository.findById(faunaDTO.getIdDepartamento()).orElse(null);
        if(departamento!=null){
            fauna.setDepartamento(departamento);
            return faunaRepository.save(fauna);
        }
        return null;
    }

    @Override
    public Fauna actualizarFauna(Fauna fauna) {
        if(faunaRepository.findById(fauna.getId()).isPresent())
            return faunaRepository.save(fauna);
        return null;
    }

    @Override
    public void eliminarFauna(Integer id) {
        if(faunaRepository.findById(id).isPresent())
            faunaRepository.deleteById(id);
    }

    @Override
    public List<String[]> obtenerFaunaDescripcion(String nombre) {
        return faunaRepository.obtenerFaunaDescripcion(nombre);
    }
}
