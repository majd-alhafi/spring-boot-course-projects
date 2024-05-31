package com.example.thymeleaf.Crud.controller;

import com.example.thymeleaf.Crud.entity.Employee;
import com.example.thymeleaf.Crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/")
    public ModelAndView getEmployees(){
        ModelAndView model = new ModelAndView("employee/list-employees");
        List<Employee> employees = employeeService.getEmployees();
        model.addObject("employees",employees);
        return model;
    }
    @GetMapping("/add-employee")
    public ModelAndView addEmployee(){
        ModelAndView model = new ModelAndView("employee/add-employee");
        Employee employee = new Employee();
        model.addObject("employee",employee);
        /*
        the previous object will be used for data binding.
        when the form is loaded the getter methods (for the 'employee' object) will be called.
        when the form is submitted the setter methods (for the 'employee' object) will be called.
         */
        return model;
    }
    @PostMapping("/create")
    public RedirectView createEmployee(@ModelAttribute("employee") Employee create){
        employeeService.save(create);
        return new RedirectView("/employees/");
    }
    @GetMapping("/update-form")
    public ModelAndView showUpdateForm(@RequestParam("employeeId") int id){
        ModelAndView model = new ModelAndView("employee/add-employee");
        Optional<Employee> employee = employeeService.findById(id);
        model.addObject("employee",employee);
        return model;
    }
    @GetMapping("/delete")
    public RedirectView deleteEmployee(@RequestParam("employeeId") int id){
        employeeService.deleteById(id);
        return new RedirectView("/employees/");
    }
}
