package com.upc.tripbundle.services;

import com.upc.tripbundle.dtos.PaqueteDTO;
import com.upc.tripbundle.entities.Atractivoturistico;
import com.upc.tripbundle.entities.Paquete;
import com.upc.tripbundle.repositories.AtractivoRepository;
import com.upc.tripbundle.repositories.PaqueteRepository;
import com.upc.tripbundle.interfaces.PaqueteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaqueteServiceImpl implements PaqueteService {
    @Autowired
    private PaqueteRepository paqueteRepository;
    private final AtractivoRepository atractivoRepository;

    public PaqueteServiceImpl(AtractivoRepository atractivoRepository) {
        this.atractivoRepository = atractivoRepository;
    }

    @Override
    public List<Paquete> obtenerPaquetes() {
        return paqueteRepository.findAll();
    }

    @Override
    public Paquete insertarPaquete(PaqueteDTO paqueteDTO,Paquete paquete) {
        Atractivoturistico atractivoturistico = atractivoRepository.findById(paqueteDTO.getIdAtractivo()).orElse(null);
        if (atractivoturistico != null) {
            paquete.setAtractivoturistico(atractivoturistico);
            return paqueteRepository.save(paquete);
        }
        return null;
    }

    @Override
    public Paquete actualizarPaquete( Paquete paquete) {
        if(paqueteRepository.findById(paquete.getId()).isPresent())
            return paqueteRepository.save(paquete);
        return null;
    }

    @Override
    public void eliminarPaquete(Integer id) {
        if(paqueteRepository.findById(id).isPresent())
            paqueteRepository.deleteById(id);
    }

    @Override
    public List<String[]> obtenerAlojamientoPorPrecio() {
        return paqueteRepository.obtenerAlojamientoPorPrecio();
    }

@Override
    public List<String[]> paqueteDepartamento(String categoria){return paqueteRepository.paqueteDepartamento(categoria);}
}
