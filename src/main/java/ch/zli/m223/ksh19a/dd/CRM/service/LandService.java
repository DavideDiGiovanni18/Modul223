package ch.zli.m223.ksh19a.dd.CRM.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ch.zli.m223.ksh19a.dd.CRM.model.Flughafen;
import ch.zli.m223.ksh19a.dd.CRM.model.Land;

@Service
public interface LandService {
	List<Land> landList();

	Land getLandById(Long id);

	Flughafen getFlughafenById(Long id);

	Flughafen insertFlughafen(String name);

	List<Flughafen> flughafenList();

	void deleteFlughafenById(Long id);
}
