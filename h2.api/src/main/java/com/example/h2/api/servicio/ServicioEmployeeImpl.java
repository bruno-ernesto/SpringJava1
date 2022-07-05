package com.example.h2.api.servicio;
import com.example.h2.api.modelo.Employee;
import com.example.h2.api.repositorio.RepositorioEmployee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
@AllArgsConstructor
public class ServicioEmployeeImpl implements  ServicioEmployee{
    private  final RepositorioEmployee repositorioEmployee;
    @Override
    public Employee guardarEmployee(Employee employee) {
        return repositorioEmployee.save(employee);
    }
    @Override
    public Optional<Employee> obtenerEmployee(Long id) {
        return Optional.ofNullable(repositorioEmployee.findById(id).orElseThrow(() -> {
            throw new RuntimeException();
        }));
    }
    @Override
    public Employee employeAModificar(Long id, Employee employeeModificar) {
        Employee employeeBuscado=repositorioEmployee.findById(id).get();
        employeeBuscado.setSurname(employeeModificar.getSurname());
        return  repositorioEmployee.save(employeeBuscado);
    }
    @Override
    public boolean eliminarEmployee(Long id) {
        try {
            repositorioEmployee.deleteById(id);
            return  true;
        }catch (Exception e){
            return false;
        }
    }
}
