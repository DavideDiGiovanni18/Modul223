package ch.zli.m223.ksh19a.dd.CRM.service;

import java.util.List;

import ch.zli.m223.ksh19a.dd.CRM.model.AppUser;

public interface UserService {
	List<AppUser> getAllUser();

	AppUser getUser(long id);

	AppUser insertUser(String name, String password);

	void deleteUserById(Long id);

}
