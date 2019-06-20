package com.sam.springtest.repository.service;


import com.sam.springtest.entity.Employee;

public interface EmployeeService<T, ID> {
    public Employee getEmployeeByName(String name);
}
