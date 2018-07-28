package com.example.demo.one.to.n.controllers.dto;


import com.example.demo.one.to.n.entities.Employee;

public class EmployeeDTO {
    private final Long id;
    private final String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getCompanyId() {
        return companyId;
    }

    private final Long companyId;

    public EmployeeDTO(Employee employee) {
        this.id = employee.getEmployee_id();
        this.name = employee.getName();
        this.companyId = employee.getCompany()!=null?employee.getCompany().getId():0;
    }
}
