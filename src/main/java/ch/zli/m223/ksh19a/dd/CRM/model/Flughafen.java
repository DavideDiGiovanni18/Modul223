package ch.zli.m223.ksh19a.dd.CRM.model;

import java.util.List;

public interface Flughafen {

	public Long getId();

	public String getName();

	public List<AppUser> getUser();

	public void addUserToList(AppUserImpl newAppUser);

}
