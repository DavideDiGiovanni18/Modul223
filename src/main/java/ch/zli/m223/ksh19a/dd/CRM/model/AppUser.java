package ch.zli.m223.ksh19a.dd.CRM.model;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

public interface AppUser extends UserDetails {
	public Long getID();

	public String getEmail();

	public List<Role> getRoles();

}
