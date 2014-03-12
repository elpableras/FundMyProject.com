package com.miw.business;

import impl.miw.presentation.postproject.PostProjectAction;

import java.util.Vector;

import com.miw.model.Project;

public interface ProjectManagerService {
	public Vector<Project> getProjects() throws Exception;

	public String setProjects(PostProjectAction postProjectAction)
			throws Exception;
}
