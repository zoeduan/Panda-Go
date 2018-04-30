package edu.uncc.ssdi.service;

import java.util.List;

import edu.uncc.ssdi.dao.UserDao;
import edu.uncc.ssdi.model.User;
import edu.uncc.ssdi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.uncc.ssdi.model.Login;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private Systems sysObject;

	@Autowired
	private UserDao userdao;

	public User findById(Long id) {
		return userRepository.findOne(id);
	}
	
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
        
    }

	public User saveUser(User user) {

		return userRepository.save(user);
	}

	public void updateUser(User user) {
		saveUser(user);
	}

	public void deleteUserById(Long id) {
		userRepository.delete(id);
	}

	public void deleteAllUsers() {
		userRepository.deleteAll();
	}

	public List<User> findAllUsers() {
		return (List<User>) userRepository.findAll();
	}

	public boolean isUserExist(User user) {
		return findByEmail(user.getFirstName()) != null;
	}

	public User validateUser(Login login) {

		return userdao.validateUser(login);

	}

	@Override
	public List<User> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User validateEmail(String email) {
		// TODO Auto-generated method stub
		return userdao.validateEmail(email);
	}

	public List<User> findByDigitalId(String name) {
		// TODO Auto-generated method stub
		return userRepository.findByDigitalId(name);
	}

}
