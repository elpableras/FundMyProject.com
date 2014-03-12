package com.miw.business;

import impl.miw.presentation.participeproject.ParticipeProjectAction;

import java.util.Vector;

import com.miw.model.Project;
import com.miw.model.Shareholder;

public interface ShareholderManagerService {
	public Vector<Shareholder> getShareholders() throws Exception;

	public String setShareholder(ParticipeProjectAction participeProjectAction)
			throws Exception;

	public String setPendiente(int id, Vector<Project> projects,
			Vector<Shareholder> shares) throws Exception;
}
