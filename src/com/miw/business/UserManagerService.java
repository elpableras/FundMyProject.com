package com.miw.business;

import impl.miw.presentation.register.RegisterAction;

import java.util.Vector;

import com.miw.model.User;

public interface UserManagerService {
	public Vector<User> getUsers() throws Exception;

	public String setUser(RegisterAction registerAction) throws Exception;
}
