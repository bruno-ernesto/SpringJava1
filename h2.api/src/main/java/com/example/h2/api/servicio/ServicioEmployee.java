package com.example.h2.api.servicio;
import  com.example.h2.api.modelo.Employee;
import  java.util.Optional;
public interface ServicioEmployee {
    Employee guardarEmployee(Employee employee);
    Optional<Employee> obtenerEmployee(Long id);
    Employee employeAModificar(Long id,Employee employeeModificar);
    boolean eliminarEmployee(Long id);
}
