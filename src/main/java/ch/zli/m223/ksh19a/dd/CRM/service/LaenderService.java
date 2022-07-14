package ch.zli.m223.ksh19a.dd.CRM.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ch.zli.m223.ksh19a.dd.CRM.model.Flughafen;
import ch.zli.m223.ksh19a.dd.CRM.model.Laender;

@Service
public interface LaenderService {
	List<Laender> landList();

	Laender getLandById(Long id);

	Flughafen getFlughafenById(Long id);

	List<Flughafen> flughafenList();
}
