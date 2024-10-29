package com.upc.tripbundle.services;

import com.upc.tripbundle.dtos.ReservaDTO;
import com.upc.tripbundle.entities.Administrador;
import com.upc.tripbundle.entities.Paquete;
import com.upc.tripbundle.entities.Reserva;
import com.upc.tripbundle.entities.Usuario;
import com.upc.tripbundle.repositories.AdministradorRepository;
import com.upc.tripbundle.repositories.PaqueteRepository;
import com.upc.tripbundle.repositories.ReservaRepository;
import com.upc.tripbundle.interfaces.ReservaService;
import com.upc.tripbundle.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaServiceImpl implements ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;
    private final PaqueteRepository paqueteRepository;
    private final AdministradorRepository administradorRepository;
    private final UsuarioRepository usuarioRepository;

    public ReservaServiceImpl(AdministradorRepository administradorRepository,
                              PaqueteRepository paqueteRepository,
                              UsuarioRepository usuarioRepository) {
        this.administradorRepository = administradorRepository;
        this.paqueteRepository = paqueteRepository;
        this.usuarioRepository = usuarioRepository;
    }



    @Override
    public List<Reserva> obtenerReservas() {
        return reservaRepository.findAll();
    }

    @Override
    public Reserva insertarReserva(ReservaDTO reservaDTO, Reserva reserva) {
        Administrador administrador=administradorRepository.findById(reserva.getAdministrador().getId()).orElse(null);
        Paquete paquete=paqueteRepository.findById(reservaDTO.getIdPaquete()).orElse(null);
        Usuario usuario=usuarioRepository.findById(reservaDTO.getIdUsuario()).orElse(null);
        if(administrador!=null&&paquete!=null&&usuario!=null) {
            reserva.setAdministrador(administrador);
            reserva.setPaquete(paquete);
            reserva.setUsuario(usuario);
           return reservaRepository.save(reserva);
        }
        return new Reserva();
    }

    @Override
    public Reserva actualizarReserva(Reserva reserva) {
        if(reservaRepository.findById(reserva.getId()).isPresent())
            return reservaRepository.save(reserva);
        return null;
    }

    @Override
    public void eliminarReserva(Integer id) {
        if(reservaRepository.findById(id).isPresent()){
            reservaRepository.deleteById(id);
        }
    }

    @Override
    public List<String[]> obtenerReservasPorDepartamento(String nombre) {
        return reservaRepository.obtenerReservasPorDepartamento(nombre);
    }

    @Override
    public List<String[]> gestionarReservas(Integer id) {
        return reservaRepository.gestionarReservas(id);
    }
    @Override
    public List<String[]> gestionarReservasDepartamento(Integer id){return reservaRepository.gestionarReservasDepartamento(id);}

    @Override
    public List<String[]> reservasUsuario(Integer id){return reservaRepository.reservasUsuario(id);}
}
