package ch.zli.m223.ksh19a.dd.CRM.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.zli.m223.ksh19a.dd.CRM.exception.LandNotFoundException;
import ch.zli.m223.ksh19a.dd.CRM.model.Flughafen;
import ch.zli.m223.ksh19a.dd.CRM.model.Laender;
import ch.zli.m223.ksh19a.dd.CRM.repository.FlughafenRepository;
import ch.zli.m223.ksh19a.dd.CRM.repository.LaenderRepository;

@Service
public class LaenderServiceImpl implements LaenderService {

	@Autowired
	public LaenderRepository laenderRepository;

	@Autowired
	public FlughafenRepository flughafenRepository;

	@Override
	public List<Laender> landList() {
		return new ArrayList<>(laenderRepository.findAll());
	}

	@Override
	public Laender getLandById(Long id) {
		return laenderRepository.findById(id).orElseThrow(() -> {
			throw new LandNotFoundException("Das Land ist nicht Verfügbar");
		});
	}

	@Override
	public Flughafen getFlughafenById(Long id) {
		return flughafenRepository.findById(id).orElseThrow(() -> {
			throw new LandNotFoundException("Das Land ist nicht Verfügbar");
		});
	}

	@Override
	public List<Flughafen> flughafenList() {
		return new ArrayList<>(flughafenRepository.findAll());
	}

}
