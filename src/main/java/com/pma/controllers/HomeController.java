package com.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pma.dao.EmployeeRepository;
import com.pma.dao.ProjectRepository;
import com.pma.entities.Employee;
import com.pma.entities.Project;

@Controller
public class HomeController {
	
	@Autowired
	ProjectRepository projRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("/")
	public String displayHome(Model model) {
		List<Project> aProjects = projRepo.findAll();
		List<Employee> aEmployees = empRepo.findAll();
		model.addAttribute("projects",aProjects);		
		model.addAttribute("employees",aEmployees);
		return "main/home";
	}

}
