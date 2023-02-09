package skypro.collectionssets.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import skypro.collectionssets.exception.EmployeeAlreadyAddedException;
import skypro.collectionssets.exception.EmployeeNotFoundException;
import skypro.collectionssets.exception.EmployeeStorageIsFullException;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService {

    List<Employee> employees = new ArrayList<>();

    public Employee addEmployee(String name, String surName)throws EmployeeAlreadyAddedException {
        Employee emp = new Employee(name, surName);
        if (!employees.contains(emp)) {
            employees.add(emp);
        } else {
            throw new EmployeeAlreadyAddedException("Сотрудник уже находится в базе");
        }
        return emp;
    }

    public Employee removeEmployee(String name, String surName)throws EmployeeNotFoundException {
        Employee employee = new Employee(name, surName);
        if (employees.contains(employee)) {
            employees.remove(employee);
            return employee;
        } else {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
    }

    public Employee searchEmployee(String name, String surName)throws EmployeeNotFoundException {
        Employee employee = new Employee(name, surName);
        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    public Collection<Employee> findAll() {
        return Collections.unmodifiableList(employees);
    }

//    public String printEmployees() {
//        for (int i = 0; i == employees.size(); i++) {
//            System.out.println(employees.toString());
//        }
//        return employees.toString();
//    }
}
