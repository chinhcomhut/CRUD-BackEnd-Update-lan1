package com.security.demospringsecurity.controller;

import com.security.demospringsecurity.model.Employee;
import com.security.demospringsecurity.service.EmployeeService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.UniqueConstraint;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/auth")
public class EmpAPIController {
@Autowired
    private EmployeeService employeeService;
@GetMapping(value = "/employee/")
public ResponseEntity<?> getListEmployee(){
    List<Employee> employees = (List<Employee>) employeeService.findAllEmployee();
    if(employees.isEmpty()){
        return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(employees, HttpStatus.OK);
}
@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") long id){
    System.out.println("Fetching Customer with id" + id);
    Employee employee = employeeService.findById(id);
    if(employee == null){
        System.out.println("Customer with id" +id+ "not found");
        return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<Employee>(employee, HttpStatus.OK);
}
    @PostMapping("/employee/")
    public ResponseEntity<?> createEmployee(@Valid @RequestBody Employee employee) {
       employee.setTitle();
       employee.setAuthor();
       employee.setDescription();
       employee.setId();
       employeeService.save(employee);
       return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
        System.out.println("Updating Employee " + id);

        Employee currentEmployee = employeeService.findById(id);

        if (currentEmployee == null) {
            System.out.println("Customer with id " + id + " not found");
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }

        currentEmployee.setTitle(employee.getTitle());
        currentEmployee.setAuthor(employee.getAuthor());
        currentEmployee.setId(employee.getId());
        currentEmployee.setDescription(employee.getDescription());

        employeeService.updateEmployee(currentEmployee);
        return new ResponseEntity<Employee>(currentEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable long id) {
        Optional<Employee> employee = Optional.ofNullable(employeeService.findById(id));
        if (!employee.isPresent()) {
//            System.out.println("Unable to delete. Customer with id " + id + " not found");
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }

        employeeService.deleteEmployee(id);
        return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
    }
}

