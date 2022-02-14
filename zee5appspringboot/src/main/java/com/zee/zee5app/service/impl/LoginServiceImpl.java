package com.zee.zee5app.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Erole;
import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.Role;
import com.zee.zee5app.repository.LoginRepository;
import com.zee.zee5app.service.LoginService;
@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
LoginRepository repo;
	@Override
	public String addCredentials(Login login) {
		// TODO Auto-generated method stub
		Login l=repo.save(login);
		System.out.println(l);
		if(l!=null)
			return "Success";
		else
			return "Failed";
	}

	@Override
	public String deleteCredentials(String userName) {
		// TODO Auto-generated method stub
		Optional<Login> l=this.getUserbyId(userName);
		if(l.isEmpty())
			return "Failed";
		else {
			repo.deleteById(userName);
			return "Success";
		}
	}

	@Override
	public String changePassword(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String changerole(String username, Erole role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Login> getUserbyId(String id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

}
