package com.security.demospringsecurity.service;

import com.security.demospringsecurity.model.Employee;
import com.security.demospringsecurity.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service("userService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee findById(Long id) {
       Optional<Employee> result =  employeeRepository.findById(id) ; // co null
       if (result.isPresent()){
            return result.get();
       }
       return  null;
    }

    @Override
    public Employee findByTitle(String title) {
        return null;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void saveEmployee(Employee employee) {

    }


    @Override
    public void updateEmployee(Employee employee) {

    }

    @Override
    public void deleteEmployee(Long id) {
     employeeRepository.deleteById(id);
    }

    @Override
    public void deleteAllUsers() {

    }

    @Override
    public Iterable<Employee> findAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public boolean isEmployeeExist(Employee employee) {
        return false;
    }

//    @Override
//    public Employee findById(Long id) {
//       Optional<Employee> result =  employeeRepository.findById(id) ; // co null
//       if (result.isPresent()){
//            return result.get();
//       }
//       return  null;
//    }
//
//
////    @Override
////    public Employee findById(Long id) {
////        Optional<Employee> one = employeeRepository.findById(id);
////        return null;
////    }
//
//    @Override
//    public Employee findByName(String title) {
//        return employeeRepository.findByTitle(title);
//    }
//
//    @Override
//    public void saveEmployee(Employee employee) {
//employeeRepository.save(employee);
//    }
//
//    @Override
//    public void updateEmployee(Employee employee) {
//saveEmployee(employee);
//    }
//
//    @Override
//    public void deleteEmployee(Long id) {
//employeeRepository.deleteAll();
//    }
//
//    @Override
//    public void deleteAllUsers() {
//employeeRepository.deleteAll();
//    }
//
//    @Override
//    public List<Employee> findAllEmployee() {
//        return employeeRepository.findAll();
//    }
//
//    @Override
//    public boolean isEmployeeExist(Employee employee) {
//        return findByName(employee.getTitle())!= null;
//    }
//}
}