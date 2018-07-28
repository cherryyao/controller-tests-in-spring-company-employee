package com.example.demo.one.to.n.controllers;

import com.example.demo.one.to.n.repositories.CompanyRepository;
import com.example.demo.one.to.n.repositories.EmployeeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(CompanyController.class)
public class ControllerTEst {
    @Autowired
    private CompanyController companyController;
    @Autowired
    private MockMvc mvc;
    @MockBean
    private CompanyRepository companyRepository;
    @MockBean
    private EmployeeRepository employeeRepository;
    @Autowired
    private ObjectMapper mapper;

    @Test
    public void aaa() throws Exception{

    }
}
