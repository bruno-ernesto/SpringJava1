package com.example.h2.api.servicio;
import com.example.h2.api.modelo.Airport;
import java.util.Optional;
public interface ServicioAirport {
    Airport guardarAirport(Airport airport);
    Optional<Airport> obtenerAirport(Long id);
    Airport airportAModificar(Long id,Airport airportModificar);
    boolean eliminarAirport(Long id);
}
