package com.upc.tripbundle.controller;

import com.upc.tripbundle.dtos.ReservaDTO;
import com.upc.tripbundle.entities.Reserva;
import com.upc.tripbundle.interfaces.ReservaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/trip")
public class ReservaController {
    @Autowired
    private ReservaService reservaService;

    @PostMapping("/admin/insertarReserva")
    public ReservaDTO insertarReserva(@RequestBody ReservaDTO reservaDTO) throws Exception{
        try {
            ModelMapper modelMapper = new ModelMapper();
            Reserva reserva = modelMapper.map(reservaDTO, Reserva.class);
            reservaService.insertarReserva(reservaDTO, reserva);
            reservaDTO = modelMapper.map(reserva, ReservaDTO.class);
            return reservaDTO;
        } catch (Exception e) {
            throw new Exception("No se puede registrar");
        }
    }

    @GetMapping("/reservas")
    public List<ReservaDTO> obtenerReservas(){
        ModelMapper modelMapper = new ModelMapper();
        List<Reserva> reservas =reservaService.obtenerReservas();
        return Arrays.asList(modelMapper.map(reservas, ReservaDTO[].class));
    }

    @GetMapping("/admin/reservaPorDepa")
    public List<String []> obtenerReservasPorDepartamento(@RequestParam String nombre){
        return reservaService.obtenerReservasPorDepartamento(nombre);
    }

    @GetMapping("/user/reservaGestion")
    public List<String[]> gestionarReservas(@RequestParam Integer id){
        return reservaService.gestionarReservas(id);
    }

    @GetMapping("/user/reservaGestionDepartamento")
    public List<String[]> gestionarReservasDepartamento(@RequestParam Integer id){
        return reservaService.gestionarReservasDepartamento(id);
    }

    @GetMapping("/reservaUsuario")
    public List<String[]> reservasUsuario(@RequestParam Integer id){
        return reservaService.reservasUsuario(id);
    }

    @PutMapping("/reserva")
    public ReservaDTO actualizarReserva(@RequestBody ReservaDTO reservaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Reserva reserva = modelMapper.map(reservaDTO, Reserva.class);
        reserva = reservaService.actualizarReserva(reserva);
        return modelMapper.map(reserva, ReservaDTO.class);
    }

    @DeleteMapping("/reserva/{id}")
    public void eliminarReserva(@PathVariable Integer id){
        reservaService.eliminarReserva(id);
    }


}
