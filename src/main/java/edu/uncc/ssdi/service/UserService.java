package edu.uncc.ssdi.service;

import java.util.List;

import edu.uncc.ssdi.model.User;
import org.springframework.stereotype.Service;

import edu.uncc.ssdi.model.Login;

@Service
public interface UserService {
	
	User findById(Long id);

	List<User> findByEmail(String email);
	
	List<User> findByDigitalId(String name);

	User saveUser(User user);

	void updateUser(User user);

	void deleteUserById(Long id);

	void deleteAllUsers();

	List<User> findAllUsers();

	boolean isUserExist(User user);

	User validateUser(Login login);

	User validateEmail(String email);
}