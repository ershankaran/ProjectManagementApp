package com.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pma.dao.EmployeeRepository;
import com.pma.dao.ProjectRepository;
import com.pma.entities.Employee;
import com.pma.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping
	public String displayEmployee(Model model) {
		List<Project> aProjects = proRepo.findAll();
		model.addAttribute("projects",aProjects);
		return "projects/list-projects";
	}
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		Project aProject = new Project();
		List<Employee> employees = empRepo.findAll();
		model.addAttribute("project",aProject);
		model.addAttribute("allEmployees",employees);
		System.out.println(aProject);
		return "projects/new-project";
	}
	
	@PostMapping("/save")
	public String createProjectForm(Project project,@RequestParam List<Long> projectEmployees,Model model) {
		// saving the project in db
		System.out.println(project);
		
		proRepo.save(project);
		
		Iterable<Employee> chosenEmployees = empRepo.findAllById(projectEmployees);
		
		for(Employee emp:chosenEmployees) {
			emp.setTheProject(project);
			empRepo.save(emp);
		}
		//use redirect to prevent duplicate submission
		return "redirect:/projects/new";
	}

}
