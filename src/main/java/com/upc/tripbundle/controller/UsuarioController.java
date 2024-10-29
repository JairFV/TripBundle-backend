package com.upc.tripbundle.controller;

import com.upc.tripbundle.dtos.UsuarioDTO;
import com.upc.tripbundle.entities.Usuario;
import com.upc.tripbundle.interfaces.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/trip")
@CrossOrigin()
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/insertarUsuario")
    public UsuarioDTO insertUsuario(@RequestBody UsuarioDTO usuarioDTO) throws Exception {
        try {
            ModelMapper modelMapper = new ModelMapper();
            Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
            usuarioService.insertarUsuario(usuario);
            usuarioDTO = modelMapper.map(usuario, UsuarioDTO.class);
            return usuarioDTO;
        } catch(Exception e) {
            throw new Exception("Error al insertar usuario");
        }
    }

    @GetMapping("/admin/usuarios")
    public List<UsuarioDTO> buscarUsuarios(){
        ModelMapper modelMapper = new ModelMapper();
        List<Usuario> usuarios = usuarioService.buscarUsuarios();
        return Arrays.asList(modelMapper.map(usuarios, UsuarioDTO[].class));
    }

    @PutMapping("/actualizarUsuario")
    public UsuarioDTO actualizarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
        usuario = usuarioService.actualizarUsuario(usuario);
        return modelMapper.map(usuario, UsuarioDTO.class);
    }

    @DeleteMapping("/usuario/{id}")
    public void eliminarUsuario(@PathVariable Integer id) {
        usuarioService.eliminarUsuario(id);
    }
}
