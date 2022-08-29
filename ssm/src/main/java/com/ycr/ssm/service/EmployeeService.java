package com.ycr.ssm.service;

import com.github.pagehelper.PageInfo;
import com.ycr.ssm.pojo.Employee;

import java.util.List;

/**
 * @author Ycr
 * @create 2022-08-26 7:39
 */
public interface EmployeeService {
    List<Employee> getAllEmployee();

    PageInfo<Employee> getEmployeePage(Integer pageNum);

    Employee getEmployeeById(Integer empId);

    void updateEmployee(Employee employee);

    void insertEmployee(Employee employee);

    void delEmployee(Integer empId);
}
