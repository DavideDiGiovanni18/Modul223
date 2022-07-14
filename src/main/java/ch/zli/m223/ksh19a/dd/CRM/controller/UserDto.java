package ch.zli.m223.ksh19a.dd.CRM.controller;

import java.util.ArrayList;
import java.util.List;

import ch.zli.m223.ksh19a.dd.CRM.model.AppUser;

public class UserDto {
	public final Long id;
	public final String name;
	public List<String> roleList;

	public UserDto(AppUser user) {
		id = user.getID();
		name = user.getEmail();
		roleList = new ArrayList<>();
		for (var role : user.getRoles()) {
			roleList.add(role.getRole());
		}
	}

}
