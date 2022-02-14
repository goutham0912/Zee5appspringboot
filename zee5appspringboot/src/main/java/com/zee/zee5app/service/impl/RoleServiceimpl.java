package com.zee.zee5app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zee.zee5app.dto.Role;
import com.zee.zee5app.repository.RoleRepository;
import com.zee.zee5app.service.RoleService;
@Service
public class RoleServiceimpl implements RoleService {
	@Autowired
RoleRepository repository;
	@Override
	@Transactional(rollbackFor = Exception.class)
	public String addRole(Role role) {
		// TODO Auto-generated method stub
		Role result=repository.save(role);
		if(result!=null)
			return "Success";
		else {
			return "Failed";
		}
		
	}

	@Override
	public void deleteRole(int roleId) {
		

	}

}
