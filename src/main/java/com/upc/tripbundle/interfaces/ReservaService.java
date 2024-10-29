package com.upc.tripbundle.interfaces;

import com.upc.tripbundle.dtos.ReservaDTO;
import com.upc.tripbundle.entities.Reserva;

import java.util.List;

public interface ReservaService {
    public List<Reserva> obtenerReservas();
    public Reserva insertarReserva(ReservaDTO reservaDTO, Reserva reserva);
    public Reserva actualizarReserva(Reserva reserva);
    public void eliminarReserva(Integer id);
    public List<String []> obtenerReservasPorDepartamento(String nombre);
    public List<String[]> gestionarReservas(Integer id);
    public List<String[]> gestionarReservasDepartamento(Integer id);
    public List<String[]> reservasUsuario(Integer id);
}
