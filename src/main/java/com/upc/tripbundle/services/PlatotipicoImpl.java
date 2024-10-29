package com.upc.tripbundle.services;

import com.upc.tripbundle.dtos.PlatotipicoDTO;
import com.upc.tripbundle.entities.Departamento;
import com.upc.tripbundle.entities.Platotipico;
import com.upc.tripbundle.interfaces.PlatotipicoService;
import com.upc.tripbundle.repositories.DepartamentoRepository;
import com.upc.tripbundle.repositories.PlatotipicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatotipicoImpl implements PlatotipicoService {
    @Autowired
    private PlatotipicoRepository platotipicoRepository;
    private DepartamentoRepository departamentoRepository;

    public PlatotipicoImpl(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    @Override
    public List<Platotipico> obtenerPlatos() {
        return platotipicoRepository.findAll();
    }

    @Override
    public Platotipico insertarPlato(PlatotipicoDTO platotipicoDTO, Platotipico platotipico) {
        Departamento departamento=departamentoRepository.findById(platotipicoDTO.getIdDepartamento()).orElse(null);
        if(departamento!=null){
            platotipico.setDepartamento(departamento);
            return platotipicoRepository.save(platotipico);
        }
        return new Platotipico();
    }

    @Override
    public Platotipico actualizarPlato(Platotipico platotipico) {
        if(platotipicoRepository.findById(platotipico.getId()).isPresent())
            return platotipicoRepository.save(platotipico);
        return null;
    }

    @Override
    public void eliminarPlato(Integer id) {
        if(platotipicoRepository.findById(id).isPresent())
            platotipicoRepository.deleteById(id);
    }

    @Override
    public List<String[]> obtenerPlatoDescripcion(String nombre) {
        return platotipicoRepository.obtenerPlatoDescripcion(nombre);
    }
}
