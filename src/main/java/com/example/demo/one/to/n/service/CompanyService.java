package com.example.demo.one.to.n.service;

import com.example.demo.one.to.n.entities.Company;
import com.example.demo.one.to.n.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService{
    @Autowired
    CompanyRepository companyRepository ;

    public List<Company> getAllCompanies(){
        return companyRepository.findAll();
    }

}
