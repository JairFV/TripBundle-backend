package com.upc.tripbundle.controller;

import com.upc.tripbundle.dtos.DepartamentoDTO;
import com.upc.tripbundle.entities.Departamento;
import com.upc.tripbundle.interfaces.DepartamentoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/trip")
public class DepartamentoController {
    @Autowired
    private DepartamentoService departamentoService;

    @PostMapping("/admin/insertarDepa")
    public DepartamentoDTO insertarDepartamento (@RequestBody DepartamentoDTO departamentoDTO) throws Exception {
        try{
            ModelMapper modelMapper = new ModelMapper();
            Departamento departamento = modelMapper.map(departamentoDTO, Departamento.class);
            departamentoService.insertarDepartamento(departamento);
            departamentoDTO = modelMapper.map(departamentoDTO, DepartamentoDTO.class);
            return departamentoDTO;
        } catch (Exception e) {
            throw new Exception("No se pudo registrar");
        }
    }

    @GetMapping("/departamentos")
    public List<DepartamentoDTO> obtenerDepartamentos(){
        ModelMapper modelMapper = new ModelMapper();
        List<Departamento> departamentos = departamentoService.obtenerDepartamentos();
        return Arrays.asList(modelMapper.map(departamentos, DepartamentoDTO[].class));
    }

    @PutMapping("/admin/actualizarDepa")
    public DepartamentoDTO actualizarDepartamento (@RequestBody DepartamentoDTO departamentoDTO){
        ModelMapper modelMapper = new ModelMapper();
        Departamento departamento = modelMapper.map(departamentoDTO, Departamento.class);
        departamento = departamentoService.actualizarDepartamento(departamento);
        return modelMapper.map(departamento, DepartamentoDTO.class);
    }

    @DeleteMapping("/admin/departamento/{id}")
    public void eliminarDepartamento(@PathVariable Integer id) {
        departamentoService.eliminarDepartamento(id);
    }
}
