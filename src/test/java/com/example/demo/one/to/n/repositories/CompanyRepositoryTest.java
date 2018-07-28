package com.example.demo.one.to.n.repositories;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.example.demo.one.to.n.entities.Company;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@DataJpaTest
public class CompanyRepositoryTest {

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void findByName_returns_Company() throws Exception {
        Company savedCompany =entityManager.persistFlushFind(new Company("oocl"));
        Company company = companyRepository.findByName("oocl");

        Assertions.assertThat(company.getName()).isEqualTo(savedCompany.getName());
    }

    @Test
    public void findById(){
        //given
        entityManager.persist(new Company("oocl"));
        entityManager.persist(new Company("abc"));
        //when
        Company company1 = companyRepository.findById(1);
        Company company2 = companyRepository.findById(2);
        //then
        assertThat(company1.getId(),is(1L));
        assertThat(company2.getId(),is(2L));
    }



}