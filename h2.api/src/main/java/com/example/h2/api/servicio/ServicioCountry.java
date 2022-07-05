package com.example.h2.api.servicio;
import com.example.h2.api.modelo.Country;
import java.util.Optional;
public interface ServicioCountry {
    Country guardarCountry(Country country);
    Optional<Country> obtenerCountry(Long id);
    Country countryAModificar(Long id,Country countryModificar);
    boolean eliminarCountry(Long id);
}
