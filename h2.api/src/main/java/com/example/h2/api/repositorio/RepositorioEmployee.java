package com.example.h2.api.repositorio;
import  com.example.h2.api.modelo.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
public interface RepositorioEmployee extends JpaRepository<Employee,Long>{
}
