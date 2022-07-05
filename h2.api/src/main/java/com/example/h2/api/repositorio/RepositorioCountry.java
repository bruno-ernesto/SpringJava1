package com.example.h2.api.repositorio;

import com.example.h2.api.modelo.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioCountry extends JpaRepository<Country,Long> {
}
