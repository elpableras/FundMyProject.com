package com.miw.persistence;

import java.util.Vector;

import com.miw.model.Project;

public interface ProjectDataService {
	public Vector<Project> getProjects() throws Exception;

	public String setProjects(Project project) throws Exception;

	public String setPercent(Double newPercent, int newShareholder,
			String idProyecto) throws Exception;
}
