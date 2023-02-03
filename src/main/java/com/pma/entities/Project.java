package com.pma.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long projectId;
	private String name;
	private String stage; //NONSTARTED,COMPLETED,INPROGRESS
	private String description;
	
	@ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST},
			   fetch=FetchType.LAZY)
	@JoinTable(name="project_employees",
	     joinColumns=@JoinColumn(name="project_id"),
	     inverseJoinColumns=@JoinColumn(name="employee_id"))
	private List<Employee> projectEmployees;
	
	public Project() {
		
	}
	
	public Project(String name, String stage, String description) {
		super();
		this.name = name;
		this.stage = stage;
		this.description = description;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Employee> getProjectEmployees() {
		return projectEmployees;
	}

	public void setProjectEmployees(List<Employee> projectEmployees) {
		this.projectEmployees = projectEmployees;
	}
	
	
}
