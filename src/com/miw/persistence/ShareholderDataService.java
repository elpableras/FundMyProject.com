package com.miw.persistence;

import impl.miw.presentation.participeproject.ParticipeProjectAction;

import java.util.Vector;

import com.miw.model.Shareholder;

public interface ShareholderDataService {
	public Vector<Shareholder> getShareholders() throws Exception;

	public String setShareholder(ParticipeProjectAction participeProjectAction)
			throws Exception;

	public String setPendiente(int id) throws Exception;
}
