package com.miw.persistence;

import impl.miw.presentation.register.RegisterAction;

import java.util.Vector;

import com.miw.model.User;

public interface UserDataService {
	public Vector<User> getUsers() throws Exception;

	public String setUser(RegisterAction registerAction) throws Exception;
}
