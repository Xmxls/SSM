package com.ycr.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.ycr.ssm.pojo.Employee;
import com.ycr.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * @author Ycr
 * @create 2022-08-26 7:38
 */

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @RequestMapping(value = "/employee/page/{pageNum}",method = RequestMethod.GET)
    public String getEmployeePage(@PathVariable("pageNum") Integer pageNum, HttpSession session){
        PageInfo<Employee> page = employeeService.getEmployeePage(pageNum);
        session.setAttribute("page",page);
        return "employee_list";
    }


    @RequestMapping(value = "/to/update/{empId}",method = RequestMethod.GET)
    public String getEmployeeById(@PathVariable("empId") Integer empId,Model model){
        Employee employee =  employeeService.getEmployeeById(empId);
        model.addAttribute("employee",employee);
        return "employee_update";
    }

    @RequestMapping(value = "/employee",method = RequestMethod.PUT)
    public String updateEmployee(Employee employee,HttpSession session){
        PageInfo page = (PageInfo) session.getAttribute("page");
        int pageNum = page.getPageNum();
        employeeService.updateEmployee(employee);
        return "redirect:/employee/page/" + pageNum;
    }

    @RequestMapping("/to/add")
    public String toAdd(){
        return "employee_add";
    }


    @RequestMapping(value = "/employee",method = RequestMethod.POST)
    public String insertEmployee(Employee employee,HttpSession session){
        PageInfo page = (PageInfo) session.getAttribute("page");
        int pageNum = page.getPages();
        employeeService.insertEmployee(employee);
        return "redirect:/employee/page/" + pageNum;
    }

    @RequestMapping(value = "/employee/{empId}",method = RequestMethod.DELETE)
    public String delEmployee(@PathVariable("empId")Integer empId,HttpSession session){
        PageInfo page = (PageInfo) session.getAttribute("page");
        int pageNum = page.getPageNum();
        employeeService.delEmployee(empId);
        return "redirect:/employee/page/" + pageNum;
    }

    public static void main(String[] args) {
        System.out.println("he");
    }

}
