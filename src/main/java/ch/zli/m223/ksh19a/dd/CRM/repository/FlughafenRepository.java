package ch.zli.m223.ksh19a.dd.CRM.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zli.m223.ksh19a.dd.CRM.model.Flughafen;
import ch.zli.m223.ksh19a.dd.CRM.model.FlughafenImpl;
import ch.zli.m223.ksh19a.dd.CRM.model.Land;
import ch.zli.m223.ksh19a.dd.CRM.model.LandImpl;

public interface FlughafenRepository extends JpaRepository<FlughafenImpl, Long> {

	default Flughafen insert(String flughafen, Land laender) {

		// Cast to Impl
		LandImpl laenderImpl = (LandImpl) laender;

		// create new Role
		FlughafenImpl newFlughafen = new FlughafenImpl(flughafen, (LandImpl) laender);

		// Save Role to DB
		FlughafenImpl savedNewFlughafen = save(newFlughafen);

		// Update Users role list
		laenderImpl.addFlughafenToList(savedNewFlughafen);

		// return new Role
		return savedNewFlughafen;
	}

	Optional<FlughafenImpl> findFlughafenByName(String name);

}
