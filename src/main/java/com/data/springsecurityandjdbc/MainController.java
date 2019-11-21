package com.data.springsecurityandjdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(path = "/demo")
public class MainController {
    @Autowired
    EmployeeRepository employeeRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String addEmployee(@Valid Employee employee){
        employeeRepository.save(employee);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    @DeleteMapping(path = "/del/{id}")
    public @ResponseBody String deleteEmployee(@PathVariable(value = "id") Long id) {
        Optional<Employee> emp = employeeRepository.findById(id);
        if (!emp.isPresent()) {
            return "Not found";
        } else {
            employeeRepository.delete(emp.get());
            return "Deleted";
        }
    }

    @GetMapping(path = "/emp/{id}")
    public @ResponseBody Employee getById(@PathVariable(value = "id") Long id){
        Employee emp=employeeRepository.findById(id).get();

        if (emp==null){
            return null;
        }
        else {
            return emp;
        }
    }
}
