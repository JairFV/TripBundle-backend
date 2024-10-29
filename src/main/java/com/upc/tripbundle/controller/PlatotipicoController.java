package com.upc.tripbundle.controller;

import com.upc.tripbundle.dtos.PlatotipicoDTO;
import com.upc.tripbundle.entities.Platotipico;
import com.upc.tripbundle.interfaces.PlatotipicoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/trip")
public class PlatotipicoController {
    @Autowired
    private PlatotipicoService platotipicoService;

    @PostMapping("/admin/insertarPlato")
    public PlatotipicoDTO insertarPlato(@RequestBody PlatotipicoDTO platotipicoDTO) throws Exception {
        try{
            ModelMapper modelMapper = new ModelMapper();
            Platotipico platotipico = modelMapper.map(platotipicoDTO, Platotipico.class);
             platotipicoService.insertarPlato(platotipicoDTO, platotipico);
             platotipicoDTO=modelMapper.map(platotipicoDTO, PlatotipicoDTO.class);
            return platotipicoDTO;
        } catch (Exception e) {
            throw new Exception("No se puede registrar");
        }
    }

    @GetMapping("/platos")
    public List<PlatotipicoDTO> obtenerPlatos() {
        ModelMapper modelMapper = new ModelMapper();
        List<Platotipico> platos = platotipicoService.obtenerPlatos();
        return Arrays.asList(modelMapper.map(platos, PlatotipicoDTO[].class));
    }

    @GetMapping("/user/platoDescripcion")
    public List<String[]> obtenerPlatoDescripcion(@RequestParam String nombre){
        return platotipicoService.obtenerPlatoDescripcion(nombre);
    }

    @PutMapping("/actualizarPlato")
    public PlatotipicoDTO actualizarPlato(@RequestBody PlatotipicoDTO platotipicoDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Platotipico plato = modelMapper.map(platotipicoDTO, Platotipico.class);
        plato = platotipicoService.actualizarPlato(plato);
        return modelMapper.map(plato, PlatotipicoDTO.class);
    }

    @DeleteMapping("/plato/{id}")
    public void deletePlato(@PathVariable Integer id) {
        platotipicoService.eliminarPlato(id);
    }
}
