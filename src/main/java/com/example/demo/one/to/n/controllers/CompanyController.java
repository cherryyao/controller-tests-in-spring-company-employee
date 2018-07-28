package com.example.demo.one.to.n.controllers;

import com.example.demo.one.to.n.controllers.dto.CompanyDTO;
import com.example.demo.one.to.n.entities.Company;
import com.example.demo.one.to.n.entities.Employee;
import com.example.demo.one.to.n.repositories.CompanyRepository;
import com.example.demo.one.to.n.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    //@Autowired
    //public CompanyController(CompanyRepository repository) {
//        this.repository = repository;
//    }

    @Transactional
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Company save(@RequestBody Company company){
        company.getEmployeesList().stream().forEach(employee -> employee.setCompany(company));
        return companyRepository.save(company);
    }

    @Transactional
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Company> findAll(){
        return companyRepository.findAll();
    }

    @Transactional
    @PutMapping(path = "/{company_id}/employees",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addEmployeeToCompany(@PathVariable Long company_id,@RequestBody Employee employee){
        Company company = companyRepository.findById(company_id).get();
        employee.setCompany(company);
        employeeRepository.save(employee);
        companyRepository.save(company);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Transactional
    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@RequestBody Company company) {
        company.getEmployeesList().stream().filter(employee -> employee.getCompany() == null).forEach(employee -> {
            employee.setCompany(company);
        });
        companyRepository.save(company);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Transactional
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CompanyDTO get(@PathVariable("id")Long id) {
        Company company = companyRepository.findById(id).get();
        return new CompanyDTO(company);
    }
    @Transactional
    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Company delete(@PathVariable("id")Long id) {
        Company one = companyRepository.findById(id).get();
        companyRepository.delete(one);
        return one;
    }

    @Transactional
    @GetMapping(path = "/{company_id}/employees", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getSpecificCompanyEmployee(@PathVariable long company_id){
        Company company = companyRepository.findById(company_id).get();
        System.out.println(company.getEmployeesList());
        return company.getEmployeesList();
    }


}

