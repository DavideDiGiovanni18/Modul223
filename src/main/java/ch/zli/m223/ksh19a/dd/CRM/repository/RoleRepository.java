package ch.zli.m223.ksh19a.dd.CRM.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zli.m223.ksh19a.dd.CRM.model.AppUser;
import ch.zli.m223.ksh19a.dd.CRM.model.AppUserImpl;
import ch.zli.m223.ksh19a.dd.CRM.model.Role;
import ch.zli.m223.ksh19a.dd.CRM.model.RoleImpl;

public interface RoleRepository extends JpaRepository<RoleImpl, Long> {

	default Role insert(String roleName, AppUser appUser) {
		// Cast to Impl
		AppUserImpl userImpl = (AppUserImpl) appUser;

		// create new Role
		RoleImpl newRole = new RoleImpl(roleName, (AppUserImpl) appUser);

		// Save Role to DB
		RoleImpl savedNewRole = save(newRole);

		// Update Users role list
		userImpl.addRoleToList(savedNewRole);

		// return new Role
		return savedNewRole;

	}

}
