package ch.zli.m223.ksh19a.dd.CRM.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zli.m223.ksh19a.dd.CRM.model.Laender;
import ch.zli.m223.ksh19a.dd.CRM.model.LaenderImpl;

public interface LaenderRepository extends JpaRepository<LaenderImpl, Long> {

	default Laender insert(String land) {
		LaenderImpl lands = new LaenderImpl(land);
		return save(lands);
	}

}
