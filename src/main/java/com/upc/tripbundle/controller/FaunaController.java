package com.upc.tripbundle.controller;

import com.upc.tripbundle.dtos.FaunaDTO;
import com.upc.tripbundle.entities.Fauna;
import com.upc.tripbundle.interfaces.FaunaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/trip")
public class FaunaController {
    @Autowired
    private FaunaService faunaService;

    @PostMapping("/admin/insertarFauna")
    public FaunaDTO insertarFauna(@RequestBody FaunaDTO faunaDTO) throws Exception {
        try{
            ModelMapper modelMapper = new ModelMapper();
            Fauna fauna = modelMapper.map(faunaDTO, Fauna.class);
            faunaDTO=modelMapper.map(fauna, FaunaDTO.class);
            faunaService.insertarFauna(faunaDTO,fauna);
            return faunaDTO;

        } catch (Exception e) {
            throw new Exception("No se puede registrar");
        }
    }

    @GetMapping("/faunas")
    public List<FaunaDTO> obtenerFaunas(){
        ModelMapper modelMapper = new ModelMapper();
        List<Fauna>faunas=faunaService.obtenerFaunas();
        return Arrays.asList(modelMapper.map(faunas, FaunaDTO[].class));
    }

    @PostMapping("/user/faunaDescripcion")
    public List<String[]> obtenerFaunaDescripcion(@RequestParam String nombre){
        return faunaService.obtenerFaunaDescripcion(nombre);
    }

    @PutMapping("/admin/actualizarFauna")
    public FaunaDTO actualizarFauna(@RequestBody FaunaDTO faunaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Fauna fauna = modelMapper.map(faunaDTO, Fauna.class);
        fauna = faunaService.actualizarFauna(fauna);
        return modelMapper.map(fauna, FaunaDTO.class);
    }

    @DeleteMapping("/admin/fauna/{id}")
    public void eliminarFauna(@PathVariable Integer id){
        faunaService.eliminarFauna(id);
    }
}
