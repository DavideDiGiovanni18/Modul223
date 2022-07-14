package ch.zli.m223.ksh19a.dd.CRM.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "Role")
public class RoleImpl implements Role {

	@Id
	@GeneratedValue
	private Long id;

	private String role;

	@ManyToOne
	private AppUserImpl appUser;

	protected RoleImpl() {
		/* for JPA only */
	}

	public RoleImpl(String role, AppUserImpl appUser) {
		this.role = role;
		this.appUser = appUser;

	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public String getRole() {
		return role;
	}

}
