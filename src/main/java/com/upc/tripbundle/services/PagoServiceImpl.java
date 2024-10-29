package com.upc.tripbundle.services;

import com.upc.tripbundle.dtos.PagoDTO;
import com.upc.tripbundle.entities.Pago;
import com.upc.tripbundle.entities.Reserva;
import com.upc.tripbundle.repositories.PagoRepository;
import com.upc.tripbundle.interfaces.PagoService;
import com.upc.tripbundle.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoServiceImpl implements PagoService {
    @Autowired
    private PagoRepository pagoRepository;
    private final ReservaRepository reservaRepository;

    public PagoServiceImpl(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    @Override
    public List<Pago> obtenerPagos() {
        return pagoRepository.findAll();
    }

    @Override
    public Pago insertarPago(PagoDTO pagoDTO, Pago pago) {
        Reserva reserva = reservaRepository.findById(pagoDTO.getIdReserva()).orElse(null);
        if (reserva != null) {
            pago.setReserva(reserva);
            return pagoRepository.save(pago);
        }
        return new Pago();
    }

    @Override
    public Pago actualizarPago(Pago pago) {
        if(pagoRepository.findById(pago.getId()).isPresent())
            return pagoRepository.save(pago);
        return null;
    }

    @Override
    public void eliminarPago(Integer id) {
        if(pagoRepository.findById(id).isPresent())
            pagoRepository.deleteById(id);
    }

    @Override
    public List<String[]> buscarPaqueteSegunPrecio() {
        return pagoRepository.buscarPaqueteSegunPrecio();
    }

    @Override
    public List<String[]> listarPagos() {
        return pagoRepository.listarPagos();
    }
}
