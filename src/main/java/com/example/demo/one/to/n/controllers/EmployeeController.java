package com.example.demo.one.to.n.controllers;

import com.example.demo.one.to.n.controllers.dto.EmployeeDTO;
import com.example.demo.one.to.n.entities.Company;
import com.example.demo.one.to.n.entities.Employee;
import com.example.demo.one.to.n.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee save(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @Transactional
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> findAllEmployee() {
        return employeeRepository.findAll();
    }

    @Transactional
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeDTO get(@PathVariable("id") Long id) {
        Employee employee = employeeRepository.findById(id).get();
        return new EmployeeDTO(employee);
    }

    @Transactional
    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee delete(@PathVariable("id")Long id) {
        Employee one = employeeRepository.findById(id).get();
        employeeRepository.delete(one);
        return one;
    }

    @Transactional
    @GetMapping(path = "/male",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> findByGender(){
       return  employeeRepository.findByGender("male");
    }

//    @Transactional
//    @GetMapping(path = "/{page}",produces = MediaType.APPLICATION_JSON_VALUE)
//    public Page<Employee> findByPage(@PathVariable Pageable page){
//        return employeeRepository.findAll(page);
//    }

//    @Transactional
//    @PutMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity updae(@PathVariable Long id,@RequestBody Employee employee){
//        Employee employee1 = employeeRepository.findById(id).get();
//        employee1.setCompany(employee.getCompany());
//        employee1.setGender(employee.getGender());
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//    }

    @Transactional
    @PutMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee updae(@PathVariable Long id,@RequestBody Employee employee){
        System.out.println(employee.getName());
        Employee employee1 = employeeRepository.findById(id).get();
        employee1.setName(employee.getName());
        employee1.setGender(employee.getGender());
        employee1.setCompany(employee.getCompany());
        return employee1;
    }









}
