package com.upc.tripbundle.interfaces;

import com.upc.tripbundle.dtos.PagoDTO;
import com.upc.tripbundle.entities.Pago;

import java.util.List;

public interface PagoService {
    public List<Pago> obtenerPagos();
    public Pago insertarPago(PagoDTO pagoDTO, Pago pago);
    public Pago actualizarPago(Pago pago);
    public void eliminarPago(Integer id);
    public List<String[]> buscarPaqueteSegunPrecio();
    public List<String[]> listarPagos();
}
