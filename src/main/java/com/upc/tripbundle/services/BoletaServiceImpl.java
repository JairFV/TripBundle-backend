package com.upc.tripbundle.services;

import com.upc.tripbundle.dtos.BoletaDTO;
import com.upc.tripbundle.entities.Boleta;
import com.upc.tripbundle.entities.Pago;
import com.upc.tripbundle.repositories.BoletaRepository;
import com.upc.tripbundle.interfaces.BoletaService;
import com.upc.tripbundle.repositories.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoletaServiceImpl implements BoletaService {
    @Autowired
    private BoletaRepository boletaRepository;
    private final PagoRepository PagoRepository;
    @Autowired
    private PagoRepository pagoRepository;

    public BoletaServiceImpl(com.upc.tripbundle.repositories.PagoRepository pagoRepository) {
        PagoRepository = pagoRepository;
    }

    @Override
    public List<Boleta> obtenerBoletas() {
        return boletaRepository.findAll();
    }

    @Override
    public Boleta insertarBoleta(BoletaDTO boletaDTO, Boleta boleta) {
        Pago pago=pagoRepository.findById(boletaDTO.getIdPago()).orElse(null);

        if(pago!=null){
            boleta.setPago(pago);
            return boletaRepository.save(boleta);
        }
        return new Boleta();
    }

    @Override
    public Boleta actualizarBoleta(Boleta boleta) {
        if(boletaRepository.findById(boleta.getId()).isPresent())
            return boletaRepository.save(boleta);
        return null;
    }

    @Override
    public void eliminarBoleta(Integer id) {
        if(boletaRepository.findById(id).isPresent())
            boletaRepository.deleteById(id);
    }

    @Override
    public List<String[]> obtenerBoletaPorUsuario( Integer id) {
        return boletaRepository.obtenerBoletaPorUsuario(id);
    }
}
