package com.upc.tripbundle.controller;

import com.upc.tripbundle.dtos.PagoDTO;
import com.upc.tripbundle.entities.Pago;
import com.upc.tripbundle.interfaces.PagoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/trip")
public class PagoController {
    @Autowired
    private PagoService pagoService;

    @PostMapping("/insertarPago")
    public PagoDTO insertarPago(@RequestBody PagoDTO pagoDTO) throws Exception {
        try {
            ModelMapper modelMapper = new ModelMapper();
            Pago pago = modelMapper.map(pagoDTO, Pago.class);
            pagoService.insertarPago(pagoDTO,pago);
            pagoDTO = modelMapper.map(pagoDTO, PagoDTO.class);
            return pagoDTO;
        } catch (Exception e) {
            throw new Exception("No se puede registrar");
        }
    }

    @GetMapping("/pagos")
    public List<PagoDTO> obtenerPagos() {
        ModelMapper modelMapper = new ModelMapper();
        List<Pago> pagos = pagoService.obtenerPagos();
        return Arrays.asList(modelMapper.map(pagos, PagoDTO[].class));
    }

    @GetMapping("/pagoPaquete")
    public List<String[]> buscarPaqueteSegunPrecio(){
        return pagoService.buscarPaqueteSegunPrecio();
    }

    @GetMapping("/admin/pagoLista")
    public List<String[]> listarPagos(){
        return pagoService.listarPagos();
    }

    @PutMapping("/actualizarPago")
    public PagoDTO actualizarPago(@RequestBody PagoDTO pagoDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Pago pago = modelMapper.map(pagoDTO, Pago.class);
        pago = pagoService.actualizarPago(pago);
        return modelMapper.map(pago, PagoDTO.class);
    }

    @DeleteMapping("/pago/{id}")
    public void eliminarPago(@PathVariable Integer id){
        pagoService.eliminarPago(id);
    }
}
