package com.example.h2.api.repositorio;
import com.example.h2.api.modelo.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
public interface RepositorioAirport extends JpaRepository<Airport,Long> {
}
