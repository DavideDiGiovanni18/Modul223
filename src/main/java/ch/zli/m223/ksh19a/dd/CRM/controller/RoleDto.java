package ch.zli.m223.ksh19a.dd.CRM.controller;

import ch.zli.m223.ksh19a.dd.CRM.model.Role;

public class RoleDto {
	public String roleName;

	public RoleDto(Role role) {
		roleName = role.getRole();
	}
}
