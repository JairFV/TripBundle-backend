package com.upc.tripbundle.controller;

import com.upc.tripbundle.dtos.PaqueteDTO;
import com.upc.tripbundle.entities.Paquete;
import com.upc.tripbundle.interfaces.PaqueteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/trip")
public class PaqueteController {
    @Autowired
    private PaqueteService paqueteService;

    @PostMapping("/admin/insertarPaquete")
    public PaqueteDTO insertarPaquete(@RequestBody PaqueteDTO paqueteDTO) throws Exception {
        try {
            ModelMapper modelMapper = new ModelMapper();
            Paquete paquete = modelMapper.map(paqueteDTO, Paquete.class);
            paqueteService.insertarPaquete(paqueteDTO,paquete);
            paqueteDTO = modelMapper.map(paqueteDTO, PaqueteDTO.class);
            return paqueteDTO;
        } catch (Exception e) {
            throw new Exception("No se puede registrar");
        }
    }

    @GetMapping("/paquetes")
    public List<PaqueteDTO> obtenerPaquetes() {
        ModelMapper modelMapper = new ModelMapper();
        List<Paquete> paquetes = paqueteService.obtenerPaquetes();
        return Arrays.asList(modelMapper.map(paquetes, PaqueteDTO[].class));
    }

    @GetMapping("/user/paqueteAlojamiento")
    public List<String[]> obtenerAlojamientoPorPrecio(){
        return paqueteService.obtenerAlojamientoPorPrecio();
    }

    @GetMapping("/user/paqueteDepartamento")
    public List<String[]> paqueteDepartamento(String categoria){return paqueteService.paqueteDepartamento(categoria);}

    @PutMapping("/paquete")
    public PaqueteDTO actualizarPaquete(@RequestBody PaqueteDTO paqueteDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Paquete paquete = modelMapper.map(paqueteDTO, Paquete.class);
        paquete = paqueteService.actualizarPaquete(paquete);
        return modelMapper.map(paquete, PaqueteDTO.class);
    }

    @DeleteMapping("/paquete/{id}")
    public void eliminarPaquete(@PathVariable Integer id){
        paqueteService.eliminarPaquete(id);
    }
}
