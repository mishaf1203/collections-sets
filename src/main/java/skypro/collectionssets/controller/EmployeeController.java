package skypro.collectionssets.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import skypro.collectionssets.service.Employee;
import skypro.collectionssets.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/find")
    public Employee find(@RequestParam(name = "name") String name,
                         @RequestParam(name = "surName") String surName) {
        return employeeService.searchEmployee(name, surName);
//        Employee employee = employeeService.searchEmployee(name, surName);
//        return String.format("Сотрудник '%s' '%s' успешно найден", name, surName);
    }

    @GetMapping("/add")
    public Employee add(@RequestParam(name = "name") String name,
                         @RequestParam(name = "surName") String surName) {
        return employeeService.addEmployee(name, surName);
//        Employee employee = employeeService.addEmployee(name, surName);
//        return String.format("<h1>Сотрудник '%s' '%s' успешно добавлен</h1>", name, surName);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam(name = "name") String name,
                        @RequestParam(name = "surName") String surName) {

        return employeeService.removeEmployee(name, surName);
//        return String.format("Сотрудник '%s' '%s' успешно удален!", name, surName);
    }


}
