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
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long employeeId;
	
	private String fName;
	private String lName;
	private String empEmail;
	
	@ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST},
			   fetch=FetchType.LAZY)
	@JoinTable(name="project_employees",
    joinColumns=@JoinColumn(name="employee_id"),
    inverseJoinColumns=@JoinColumn(name="project_id"))
	private List<Project> theProjects;
	
	public Employee(String fName, String lName, String employeeEmail) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.empEmail = employeeEmail;
	}
	
	public Employee() {
		
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public List<Project> getTheProjects() {
		return theProjects;
	}

	public void setTheProjects(List<Project> theProjects) {
		this.theProjects = theProjects;
	}

	
   
	

}
