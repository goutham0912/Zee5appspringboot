package com.zee.zee5app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.User;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.exception.RecordExists;

public interface UserService {
	public User addUser(User register) throws RecordExists;
	public String updateUser(Long id, User register);
	public User getUserById(Long id) throws IdNotFoundException;
	public User[] getAllUsers() throws InvalidIdLengthException, InvalidNameException, InvalidPasswordException;
	public String deleteUserById(Long id) throws IdNotFoundException;
	public Optional<List<User>> getAllUsers1() throws InvalidIdLengthException, InvalidNameException, InvalidPasswordException;
}
