package com.upc.tripbundle.controller;

import com.upc.tripbundle.dtos.FloraDTO;
import com.upc.tripbundle.entities.Flora;
import com.upc.tripbundle.interfaces.FloraService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/trip")
public class FloraController {
    @Autowired
    private  FloraService floraService;

    @PostMapping("/admin/insertarFlora")
    public FloraDTO insertarFlora(@RequestBody FloraDTO floraDTO) throws Exception {
        try{
            ModelMapper modelMapper = new ModelMapper();
            Flora flora = modelMapper.map(floraDTO, Flora.class);
            floraService.insertarFlora(floraDTO, flora);
           floraDTO=modelMapper.map(flora, FloraDTO.class);
            return floraDTO;
        } catch (Exception e) {
            throw new Exception("No se puede registrar");
        }
    }

    @GetMapping("/floras")
    public List<FloraDTO> obtenerFloras() {
        ModelMapper modelMapper = new ModelMapper();
        List<Flora> floras = floraService.obtenerFloras();
        return Arrays.asList(modelMapper.map(floras, FloraDTO[].class));
    }

    @GetMapping("/user/floraDescripcion")
    public List<String[]> obtenerFloraDescripcion(@RequestParam String nombre){
        return floraService.obtenerFloraDescripcion(nombre);
    }

    @PutMapping("/admin/flora")
    public FloraDTO actualizarFlora(@RequestBody FloraDTO floraDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Flora flora = modelMapper.map(floraDTO, Flora.class);
        flora = floraService.actualizarFlora(flora);
        return modelMapper.map(flora, FloraDTO.class);
    }

    @DeleteMapping("/flora/{id}")
    public void eliminarFlora(@PathVariable Integer id) {
        floraService.eliminarFlora(id);
    }
}
