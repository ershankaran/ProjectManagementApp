package com.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pma.dao.EmployeeRepository;
import com.pma.entities.Employee;


@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping
	public String displayEmployee(Model model) {
		List<Employee> aEmployees = empRepo.findAll();
		model.addAttribute("employees",aEmployees);
		return "employees/list-employees";
	}
	
	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {
		Employee aEmployee = new Employee();
		model.addAttribute("employee",aEmployee);
		System.out.println(aEmployee);
		return "employees/new-employee";
	}
	
	@PostMapping("/save")
	public String createEmployeeForm(Employee employee,Model model) {
		// saving the project in db
		System.out.println(employee);
		empRepo.save(employee);
		
		//use redirect to prevent duplicate submission
		return "redirect:/employees/new";
	}

}
