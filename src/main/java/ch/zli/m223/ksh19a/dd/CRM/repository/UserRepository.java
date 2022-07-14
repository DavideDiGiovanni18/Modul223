package ch.zli.m223.ksh19a.dd.CRM.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zli.m223.ksh19a.dd.CRM.model.AppUser;
import ch.zli.m223.ksh19a.dd.CRM.model.AppUserImpl;
import ch.zli.m223.ksh19a.dd.CRM.model.Flughafen;
import ch.zli.m223.ksh19a.dd.CRM.model.FlughafenImpl;

public interface UserRepository extends JpaRepository<AppUserImpl, Long> {

	default AppUser insert(String username, String password, Flughafen hafen) {
		// Cast to Impl
		FlughafenImpl flughafenImpl = (FlughafenImpl) hafen;

		// create new User
		AppUserImpl newUser = new AppUserImpl(username, password, (FlughafenImpl) hafen);

		// Save Role to DB
		AppUserImpl savedNewuser = save(newUser);

		// Update Users role list
		flughafenImpl.addUserToList(savedNewuser);

		// return new Role
		return save(savedNewuser);
	}

	Optional<AppUserImpl> findUserByName(String name);

}
