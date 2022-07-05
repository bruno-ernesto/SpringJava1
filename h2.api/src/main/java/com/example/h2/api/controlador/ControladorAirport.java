package com.example.h2.api.controlador;

import com.example.h2.api.modelo.Airport;
import com.example.h2.api.servicio.ServicioAirport;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/airport")
@RequiredArgsConstructor
public class ControladorAirport {
    private final ServicioAirport servicioAirport;
    @PostMapping
    public ResponseEntity guardarAirport(@RequestBody Airport airport){
        return new ResponseEntity(servicioAirport.guardarAirport(airport), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity obtenerAirport(@PathVariable("id")Long id){
        return new ResponseEntity(servicioAirport.obtenerAirport(id), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity modificarAirport(@PathVariable("id")Long id, @RequestBody Airport airport){
        return new ResponseEntity(servicioAirport.airportAModificar(id,airport), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity eliminarAirport(@PathVariable("id")Long id){
        boolean respuesta= servicioAirport.eliminarAirport(id);
        if(respuesta== true){
            return new ResponseEntity( HttpStatus.OK);
        }else{
            return new ResponseEntity( HttpStatus.NOT_FOUND);
        }
    }
}
