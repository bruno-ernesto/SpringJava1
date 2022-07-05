package com.example.h2.api.controlador;
import com.example.h2.api.modelo.Country;
import com.example.h2.api.servicio.ServicioCountry;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/country")
@RequiredArgsConstructor
public class ControladorCountry {
    private  final ServicioCountry servicioCountry;
    @PostMapping
    public ResponseEntity guardarCountry(@RequestBody Country country){
        return new ResponseEntity(servicioCountry.guardarCountry(country), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity obtenerCountry(@PathVariable("id")Long id){
        return new ResponseEntity(servicioCountry.obtenerCountry(id), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity modificarCountry(@PathVariable("id")Long id, @RequestBody Country country){
        return new ResponseEntity(servicioCountry.countryAModificar(id,country), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity eliminarCountry(@PathVariable("id")Long id){
        boolean respuesta= servicioCountry.eliminarCountry(id);
        if(respuesta== true){
            return new ResponseEntity( HttpStatus.OK);
        }else{
            return new ResponseEntity( HttpStatus.NOT_FOUND);
        }
    }
}
