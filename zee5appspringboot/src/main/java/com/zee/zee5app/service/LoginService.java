package com.zee.zee5app.service;

import java.util.Optional;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.ROLE;

public interface LoginService {
	public String addCredentials(Login login);
	public Optional<Login> getUserbyId(String id);
	public String deleteCredentials(String userName);

	public String changePassword(String userName,String password);
	public String changerole(String username,ROLE role);
}
