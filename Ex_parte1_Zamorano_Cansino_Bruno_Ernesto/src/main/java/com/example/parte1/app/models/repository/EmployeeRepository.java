package com.example.parte1.app.models.repository;
import java.math.BigInteger;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.parte1.app.models.entity.Employee;
@Repository

public interface EmployeeRepository {
	@Query(
			value = "select count(surname) from ejercicio1_new.Employee u where surname = :surname", nativeQuery = true
	)
	public BigInteger countUser(@Param("surname") String surname);
}
