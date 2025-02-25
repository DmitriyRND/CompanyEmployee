package org.example.companyemployee.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.companyemployee.model.Company;
import org.example.companyemployee.model.Employee;
import org.example.companyemployee.repository.CompanyRepository;
import org.example.companyemployee.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public List<Employee> findAllEmployee() {
       return employeeRepository.findAll();
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee with id " + id + " not found"));
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public Employee update(Long id,Employee employee){
        Employee employeeToUpdate = employeeRepository.findById(id).orElse(null);

            employeeToUpdate.setFirstName(employee.getFirstName());
            employeeToUpdate.setLastName(employee.getLastName());
            employeeToUpdate.setPosition(employee.getPosition());
            return employeeRepository.save(employeeToUpdate);


    }



}
