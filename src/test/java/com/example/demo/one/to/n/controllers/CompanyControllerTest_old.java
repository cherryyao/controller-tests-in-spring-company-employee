package com.example.demo.one.to.n.controllers;


import com.example.demo.one.to.n.entities.Company;
import com.example.demo.one.to.n.repositories.CompanyRepository;
import com.example.demo.one.to.n.repositories.EmployeeRepository;
import com.example.demo.one.to.n.service.CompanyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import javax.swing.*;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CompanyController.class)
public class CompanyControllerTest_old {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @MockBean
    private CompanyService companyService;


    @Test
    public void save() throws Exception {
    }

//    @Test
//    public void should_get_all_companies()throws Exception {
//        //given
//        Company company1 = new Company(1L,"oocl");
//        Company company2 = new Company(2L,"abc");
//        List<Company> companyList = Arrays.asList(company1,company2);
//        given(companyService.getAllCompanies()).willReturn(companyList);
//        //when
//        ResultActions result = mockMvc.perform(get("/companies"));
//        //then
//        result.andExpect(status().isOk())
//                .andExpect(jsonPath("$",hasSize(2)))
//                .andExpect(jsonPath("$[0].content.id",is(1)))
//                .andExpect(jsonPath("$[0].content.name",containsString("oocl")))
//                .andExpect(jsonPath("$[1].content.id",is(2)))
//                .andExpect(jsonPath("$[2].content.name",containsString("abc")));
//    }
//
//    @Test
//    public void addEmployeeToCompany()throws Exception  {
//    }
//
//    @Test
//    public void update() {
//    }
//
//    @Test
//    public void should_get_specific_company()throws Exception  {
////        Company companies =new Company();
////        given(this.companyRepository.findById(1)).willReturn(companies);
////        mockMvc.perform(get("/companies")).andExpect(status().isOk());
//    }
//
//    @Test
//    public void delete()throws Exception  {
//    }
//
//    @Test
//    public void getSpecificCompanyEmployee()throws Exception  {
//    }
}