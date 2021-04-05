package com.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ModelAndView getEmployeeList(){
        List<Employee> list = employeeService.getListOfEmployees();
        ModelAndView modelAndView = new ModelAndView("employees");
        modelAndView.addObject("listEmployees", list);
        return modelAndView;
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public ModelAndView addEmployeeView(){
        return new ModelAndView("addEmployee");
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addEmployeeSubmit(@ModelAttribute("employee") Employee employee){
        employeeService.addEmployee(employee);
        return "redirect:list";
    }

    @RequestMapping(value = "/update/{employeeName}",method = RequestMethod.GET)
    public ModelAndView updateEmployeeView(@PathVariable String employeeName){
        Employee emp = employeeService.findEmployee(employeeName);
     ModelAndView modelAndView =  new ModelAndView("updateEmployee");
     modelAndView.addObject("employee",emp);
     return modelAndView;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String updateEmployeeSubmit(@ModelAttribute("employee") Employee employee){
        employeeService.updateEmployee(employee);
        return "redirect:list";
    }

    @RequestMapping(value = "/delete/{employeeName}", method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable String employeeName){
        employeeService.deleteEmployee(employeeName);
        return "redirect:list";
    }

    @RequestMapping(value = "/find/{employeeName}", method = RequestMethod.GET)
    public ModelAndView findEmployee(@PathVariable String employeeName){
        Employee employee = employeeService.findEmployee(employeeName);
        return new ModelAndView("findEmployee").addObject("employee",employee);
    }

}
