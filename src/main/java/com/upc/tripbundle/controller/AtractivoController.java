package com.upc.tripbundle.controller;

import com.upc.tripbundle.dtos.AtractivoDTO;
import com.upc.tripbundle.entities.Atractivoturistico;
import com.upc.tripbundle.interfaces.AtractivoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/trip")
public class AtractivoController {
    @Autowired
    private AtractivoService atractivoService;

    @PostMapping("/admin/insertarAtractivo")
    public AtractivoDTO insertarAtractivo(@RequestBody AtractivoDTO atractivoDTO) throws Exception {
        try{
            ModelMapper modelMapper = new ModelMapper();
            Atractivoturistico atractivo = modelMapper.map(atractivoDTO, Atractivoturistico.class);
            atractivoService.insertarAtractivo(atractivoDTO,atractivo);
            atractivoDTO = modelMapper.map(atractivoDTO, AtractivoDTO.class);
            return atractivoDTO;
        } catch (Exception e) {
            throw new Exception("No se pudo registrar");
        }
    }

    @GetMapping("/atractivos")
    public List<AtractivoDTO> obtenerAtractivos(){
        ModelMapper modelMapper = new ModelMapper();
        List<Atractivoturistico> atractivos = atractivoService.obtenerAtractivo();
        return Arrays.asList(modelMapper.map(atractivos, AtractivoDTO[].class));
    }

    @GetMapping("/user/atractivosCantidadVisitantes")
    public List<String[]> AtrativoPorCantiddadPersonasVisitadas(){return atractivoService.AtrativoPorCantiddadPersonasVisitadas();}

    @GetMapping("/user/mejoresAtractivos")
    public List<String[]> MejoresAtrativos(){
        return atractivoService.MejoresAtrativos();
    }

    @PutMapping("/admin/actualizarAtractivo")
    public AtractivoDTO actualizarAtractivo(@RequestBody AtractivoDTO atractivoDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Atractivoturistico atractivo = modelMapper.map(atractivoDTO, Atractivoturistico.class);
        atractivo = atractivoService.actualizarAtractivo(atractivo);
        return modelMapper.map(atractivo, AtractivoDTO.class);
    }

    @DeleteMapping("/admin/atractivo/{id}")
    public void eliminarAtractivo(Integer id) {
        atractivoService.eliminarAtractivo(id);
    }
}
