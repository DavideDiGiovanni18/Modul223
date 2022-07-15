package ch.zli.m223.ksh19a.dd.CRM.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zli.m223.ksh19a.dd.CRM.model.Land;
import ch.zli.m223.ksh19a.dd.CRM.model.LandImpl;

public interface LandRepository extends JpaRepository<LandImpl, Long> {

	default Land insert(String land) {
		LandImpl lands = new LandImpl(land);
		return save(lands);
	}

}
