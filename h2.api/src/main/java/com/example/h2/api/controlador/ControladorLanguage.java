package com.example.h2.api.controlador;
import com.example.h2.api.modelo.Language;
import com.example.h2.api.servicio.ServicioLanguage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/language")
@RequiredArgsConstructor
public class ControladorLanguage {
    private  final ServicioLanguage servicioLanguage;
    @PostMapping
    public ResponseEntity guardarLanguge(@RequestBody Language language){
        return new ResponseEntity(servicioLanguage.guardarLanguage(language), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity obtenerLanguge(@PathVariable("id")Long id){
        return new ResponseEntity(servicioLanguage.obtenerLanguage(id), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity modificarLanguage(@PathVariable("id")Long id, @RequestBody Language language){
        return new ResponseEntity(servicioLanguage.languageAModificar(id,language), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity eliminarLanguage(@PathVariable("id")Long id){
        boolean respuesta= servicioLanguage.eliminarLanguage(id);
        if(respuesta== true){
            return new ResponseEntity( HttpStatus.OK);
        }else{
            return new ResponseEntity( HttpStatus.NOT_FOUND);
        }
    }
}
