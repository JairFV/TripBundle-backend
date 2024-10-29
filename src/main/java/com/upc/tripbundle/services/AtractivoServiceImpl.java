package com.upc.tripbundle.services;

import com.upc.tripbundle.dtos.AtractivoDTO;
import com.upc.tripbundle.entities.Atractivoturistico;
import com.upc.tripbundle.entities.Departamento;
import com.upc.tripbundle.interfaces.AtractivoService;
import com.upc.tripbundle.repositories.AtractivoRepository;
import com.upc.tripbundle.repositories.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtractivoServiceImpl implements AtractivoService {
    @Autowired
    private AtractivoRepository atractivoRepository;
    private final DepartamentoRepository departamentoRepository;

    public AtractivoServiceImpl(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    @Override
    public List<Atractivoturistico> obtenerAtractivo() {
        return atractivoRepository.findAll();
    }

    @Override
    public Atractivoturistico insertarAtractivo(AtractivoDTO atractivoDTO, Atractivoturistico atractivo) {
        Departamento departamento = departamentoRepository.findById(atractivoDTO.getIdDepartamento()).orElse(null);
       if (departamento != null) {
           atractivo.setDepartamento(departamento);
           return atractivoRepository.save(atractivo);
       }
        return new Atractivoturistico();

    }

    @Override
    public Atractivoturistico actualizarAtractivo(Atractivoturistico atractivo) {
        if(atractivoRepository.findById(atractivo.getId()).isEmpty())
            return atractivoRepository.save(atractivo);
        return null;
    }

    @Override
    public void eliminarAtractivo(Integer id) {
        if(atractivoRepository.findById(id).isEmpty())
            atractivoRepository.deleteById(id);
    }
    @Override
    public List<String[]> AtrativoPorCantiddadPersonasVisitadas(){ return atractivoRepository.AtrativoPorCantiddadPersonasVisitadas();}

    @Override
    public List<String[]> MejoresAtrativos() {
        return atractivoRepository.MejoresAtrativos();
    }
}
