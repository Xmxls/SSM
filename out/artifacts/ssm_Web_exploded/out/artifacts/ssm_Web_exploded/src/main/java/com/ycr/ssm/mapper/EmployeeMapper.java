package com.ycr.ssm.mapper;

import com.ycr.ssm.pojo.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author Ycr
 * @create 2022-08-26 7:47
 */
public interface EmployeeMapper {
    List<Employee> getAllEmployee();

    Employee getEmployeeById(@Param("empId") Integer empId);

    void updateEmployee(@Param("employee") Employee employee);

    void insertEmployee(@Param("employee") Employee employee);

    void delEmployee(@Param("empId") Integer empId);
}
