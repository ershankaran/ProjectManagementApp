package com.pma.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pma.entities.Project;

public interface ProjectRepository extends CrudRepository<Project,Long> {
	
	@Override
	public List<Project> findAll();

}
