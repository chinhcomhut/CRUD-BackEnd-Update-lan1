package com.security.demospringsecurity.repository;

import com.security.demospringsecurity.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByTitle(String title);
}
