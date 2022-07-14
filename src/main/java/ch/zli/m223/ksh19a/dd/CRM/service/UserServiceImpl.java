package ch.zli.m223.ksh19a.dd.CRM.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.zli.m223.ksh19a.dd.CRM.exception.InvalidArgumentException;
import ch.zli.m223.ksh19a.dd.CRM.exception.UserAllreadyExistsException;
import ch.zli.m223.ksh19a.dd.CRM.exception.UserNotFoundException;
import ch.zli.m223.ksh19a.dd.CRM.model.AppUser;
import ch.zli.m223.ksh19a.dd.CRM.repository.FlughafenRepository;
import ch.zli.m223.ksh19a.dd.CRM.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	public FlughafenRepository flughafenRepository;

	@Override
	public List<AppUser> getAllUser() {
		return new ArrayList<>(userRepository.findAll());
	}

	@Override
	public AppUser getUser(long id) {
		return userRepository.findById(id).orElseThrow(() -> {
			throw new UserNotFoundException("Invalid User ID");
		});
	}

	@Override
	public AppUser insertUser(String name, String password) {
		if (name == null)
			throw new InvalidArgumentException("Name must not be null");
		if (userRepository.findUserByName(name).isPresent()) {// if not null
			throw new UserAllreadyExistsException("User with name" + name + "already exists");
		}
		return userRepository.insert(name, password, null);
	}

	@Override
	public void deleteUserById(Long id) {
		if (id == null)
			throw new InvalidArgumentException("Name must not be null");

	}
}
