package com.example.h2.api.servicio;
import com.example.h2.api.modelo.Airport;
import com.example.h2.api.modelo.Employee;
import com.example.h2.api.repositorio.RepositorioAirport;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
@AllArgsConstructor
public class ServicioAirportImpl implements ServicioAirport {
    private  final RepositorioAirport repositorioAirport;
    @Override
    public Airport guardarAirport(Airport airport) {
        return repositorioAirport.save(airport);
    }
    @Override
    public Optional<Airport> obtenerAirport(Long id) {
        return Optional.ofNullable(repositorioAirport.findById(id).orElseThrow(() -> {
            throw new RuntimeException();
        }));
    }
    @Override
    public Airport airportAModificar(Long id, Airport airportModificar) {
        Airport airportBuscado=repositorioAirport.findById(id).get();
        airportBuscado.setName_A(airportModificar.getName_A());
        return  repositorioAirport.save(airportBuscado);
    }
    @Override
    public boolean eliminarAirport(Long id) {
        try {
            repositorioAirport.deleteById(id);
            return  true;
        }catch (Exception e){
            return false;
        }
    }
}
