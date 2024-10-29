package com.upc.tripbundle.controller;

import com.upc.tripbundle.dtos.AdministradorDTO;
import com.upc.tripbundle.entities.Administrador;
import com.upc.tripbundle.interfaces.AdministradorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/trip")

public class AdministradorController {

    @Autowired
    private AdministradorService administradorService ;

    @PostMapping("/admin/insertarAdmin")
    public AdministradorDTO insertarAdministrador(@RequestBody AdministradorDTO administradorDTO) throws Exception {
        try {
            ModelMapper modelMapper = new ModelMapper();
            Administrador administrador = modelMapper.map(administradorDTO, Administrador.class);
            administradorService.insertarAdministrador(administrador);
            administradorDTO = modelMapper.map(administrador, AdministradorDTO.class);
            return administradorDTO;
        } catch(Exception e) {
            throw new Exception("Error al insertar administrador");
        }
    }

    @GetMapping("/administradores")
    public List<AdministradorDTO> buscarAdministradores(){
        ModelMapper modelMapper = new ModelMapper();
        List<Administrador> administradores = administradorService.buscarAdministrador();
        return Arrays.asList(modelMapper.map(administradores,AdministradorDTO[].class));
    }

    @PutMapping("/actualizarAdmin")
    public AdministradorDTO actualizarAdministrador(@RequestBody AdministradorDTO administradorDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Administrador administrador = modelMapper.map(administradorDTO, Administrador.class);
        administrador = administradorService.actualizarAdministrador(administrador);
        return modelMapper.map(administrador, AdministradorDTO.class);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarAdministrador(@PathVariable Integer id){
        administradorService.eliminarAdministrador(id);
    }
}
