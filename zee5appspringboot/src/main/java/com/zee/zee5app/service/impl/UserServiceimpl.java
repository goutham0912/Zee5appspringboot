package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.service.UserService;
@Service
public class UserServiceimpl implements UserService {
	
	//private static UserService service;
	
	@Autowired
	UserRepository repository;
	@Override
	public String addUser(Register register) {
		
		Register register2=repository.save(register);
		if(register2!=null)
			return "Success";
		else {
			return "Failure";
		}
		
	}
	@Override
	public String updateUser(String id, Register register) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Optional<Register> getUserById(String id)
			throws IdNotFoundException, InvalidIdLengthException, InvalidNameException, InvalidPasswordException {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}
	@Override
	public Register[] getAllUsers() throws InvalidIdLengthException, InvalidNameException, InvalidPasswordException {
		// TODO Auto-generated method stub
		
		List<Register> list=repository.findAll();
		Register[] r=new Register[list.size()];
		return list.toArray(r);
	}
	@Override
	public String deleteUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Register> optional;
		try {
			optional = this.getUserById(id);
			if(optional.isEmpty())
				throw new IdNotFoundException("Id not found");
			else
			{
				repository.deleteById(id);
				return "Success";
			}
		} catch (IdNotFoundException | InvalidIdLengthException | InvalidNameException | InvalidPasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());		
			}
		
		
		
	}
	@Override
	public Optional<List<Register>> getAllUsers1()
			throws InvalidIdLengthException, InvalidNameException, InvalidPasswordException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(repository.findAll());
	}

	

}
