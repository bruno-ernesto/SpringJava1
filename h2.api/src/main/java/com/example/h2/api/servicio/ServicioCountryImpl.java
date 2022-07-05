package com.example.h2.api.servicio;
import com.example.h2.api.modelo.Country;
import com.example.h2.api.repositorio.RepositorioCountry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
@AllArgsConstructor
public class ServicioCountryImpl implements ServicioCountry {
    private  final RepositorioCountry repositorioCountry;
    @Override
    public Country guardarCountry(Country country) {
        return repositorioCountry.save(country);
    }
    @Override
    public Optional<Country> obtenerCountry(Long id) {
        return Optional.ofNullable(repositorioCountry.findById(id).orElseThrow(() -> {
            throw new RuntimeException();
        }));
    }
    @Override
    public Country countryAModificar(Long id, Country countryModificar) {
        Country countryBuscado=repositorioCountry.findById(id).get();
        countryBuscado.setName_C(countryModificar.getName_C());
        return  repositorioCountry.save(countryBuscado);
    }
    @Override
    public boolean eliminarCountry(Long id) {
        try {
            repositorioCountry.deleteById(id);
            return  true;
        }catch (Exception e){
            return false;
        }
    }
}
