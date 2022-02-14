package com.zee.zee5app.service;

import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Role;
@Service
public interface RoleService {
 public String addRole(Role role);
 public void deleteRole(int roleId);
}
