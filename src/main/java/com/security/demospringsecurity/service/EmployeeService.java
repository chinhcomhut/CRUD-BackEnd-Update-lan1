package com.security.demospringsecurity.service;

import com.security.demospringsecurity.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee findById (Long id);
    Employee findByTitle (String title);
    Employee save(Employee employee);
    void saveEmployee (Employee employee);
    void updateEmployee (Employee employee);
    void deleteEmployee (Long id);
    void deleteAllUsers();
    Iterable<Employee> findAllEmployee();
    boolean isEmployeeExist (Employee employee);
}
