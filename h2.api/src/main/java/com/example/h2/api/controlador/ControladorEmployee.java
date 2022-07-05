package com.example.h2.api.controlador;
import com.example.h2.api.modelo.Employee;
import com.example.h2.api.servicio.ServicioEmployee;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class ControladorEmployee {
    private  final ServicioEmployee servicioEmployee;
    @PostMapping
    public ResponseEntity guardarEmployee(@RequestBody Employee employee){
        return new ResponseEntity(servicioEmployee.guardarEmployee(employee), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity obtenerEmployee(@PathVariable("id")Long id){
        return new ResponseEntity(servicioEmployee.obtenerEmployee(id), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity modificarEmployee(@PathVariable("id")Long id, @RequestBody Employee employee){
        return new ResponseEntity(servicioEmployee.employeAModificar(id,employee), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity eliminarEmployee(@PathVariable("id")Long id){
        boolean respuesta= servicioEmployee.eliminarEmployee(id);
        if(respuesta== true){
            return new ResponseEntity( HttpStatus.OK);
        }else{
            return new ResponseEntity( HttpStatus.NOT_FOUND);
        }
    }
}

