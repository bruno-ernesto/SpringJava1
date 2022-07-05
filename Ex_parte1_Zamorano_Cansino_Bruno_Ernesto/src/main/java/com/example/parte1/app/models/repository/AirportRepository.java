package com.example.parte1.app.models.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.parte1.app.models.entity.Airport;
@Repository
public interface AirportRepository extends CrudRepository<Airport, Long> {

}
