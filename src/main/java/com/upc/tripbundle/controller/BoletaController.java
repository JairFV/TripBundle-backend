package com.upc.tripbundle.controller;

import com.upc.tripbundle.dtos.BoletaDTO;
import com.upc.tripbundle.entities.Boleta;
import com.upc.tripbundle.interfaces.BoletaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/trip")
public class BoletaController {
    @Autowired
    private BoletaService boletaService;

    @PostMapping("/admin/insertarBoleta")
    public BoletaDTO insertarBoleta(@RequestBody BoletaDTO boletaDTO) throws Exception {
        try{
            ModelMapper modelMapper = new ModelMapper();
            Boleta boleta = modelMapper.map(boletaDTO, Boleta.class);
            boletaService.insertarBoleta(boletaDTO,boleta);
            boletaDTO = modelMapper.map(boleta, BoletaDTO.class);
            return boletaDTO;
        } catch (Exception e) {
            throw new Exception("No se pudo registrar");
        }
    }

    @GetMapping("/boletas")
    public List<BoletaDTO> obtenerBoletas(){
        ModelMapper modelMapper = new ModelMapper();
        List<Boleta> boletas = boletaService.obtenerBoletas();
        return Arrays.asList(modelMapper.map(boletas, BoletaDTO[].class));
    }

    @GetMapping("/user/boletaPorUsuario")
    public List<String[]> obtenerBoletaPorUsuario(@RequestParam Integer id){
        return boletaService.obtenerBoletaPorUsuario(id);
    }

    @PutMapping("/admin/actualizarBoleta")
    public BoletaDTO actualizarBoleta(@RequestBody BoletaDTO boletaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Boleta boleta = modelMapper.map(boletaDTO, Boleta.class);
        boleta = boletaService.actualizarBoleta(boleta);
        return modelMapper.map(boleta, BoletaDTO.class);
    }

    @DeleteMapping("/boleta/{id}")
    public void eliminarBoleta(Integer id) {
        boletaService.eliminarBoleta(id);
    }
}
