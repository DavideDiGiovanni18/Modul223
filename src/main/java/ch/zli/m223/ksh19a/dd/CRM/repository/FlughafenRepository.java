package ch.zli.m223.ksh19a.dd.CRM.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zli.m223.ksh19a.dd.CRM.model.Flughafen;
import ch.zli.m223.ksh19a.dd.CRM.model.FlughafenImpl;
import ch.zli.m223.ksh19a.dd.CRM.model.Laender;
import ch.zli.m223.ksh19a.dd.CRM.model.LaenderImpl;

public interface FlughafenRepository extends JpaRepository<FlughafenImpl, Long> {

	default Flughafen insert(String flughafen, Laender laender) {

		// Cast to Impl
		LaenderImpl laenderImpl = (LaenderImpl) laender;

		// create new Role
		FlughafenImpl newFlughafen = new FlughafenImpl(flughafen, (LaenderImpl) laender);

		// Save Role to DB
		FlughafenImpl savedNewFlughafen = save(newFlughafen);

		// Update Users role list
		laenderImpl.addFlughafenToList(savedNewFlughafen);

		// return new Role
		return savedNewFlughafen;

	}

}
