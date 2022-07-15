package ch.zli.m223.ksh19a.dd.CRM.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.zli.m223.ksh19a.dd.CRM.exception.InvalidArgumentException;
import ch.zli.m223.ksh19a.dd.CRM.exception.LandNotFoundException;
import ch.zli.m223.ksh19a.dd.CRM.exception.UserAllreadyExistsException;
import ch.zli.m223.ksh19a.dd.CRM.model.Flughafen;
import ch.zli.m223.ksh19a.dd.CRM.model.Land;
import ch.zli.m223.ksh19a.dd.CRM.repository.FlughafenRepository;
import ch.zli.m223.ksh19a.dd.CRM.repository.LandRepository;

@Service
public class LandServiceImpl implements LandService {

	@Autowired
	public LandRepository laenderRepository;

	@Autowired
	public FlughafenRepository flughafenRepository;

	@Override
	public List<Land> landList() {
		return new ArrayList<>(laenderRepository.findAll());
	}

	@Override
	public Land getLandById(Long id) {
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

	@Override
	public Flughafen insertFlughafen(String name) {
		if (name == null) {
			throw new InvalidArgumentException("Please Enter a name");
		}
		if (flughafenRepository.findFlughafenByName(name).isPresent()) {// if not null
			throw new UserAllreadyExistsException("User with name" + name + "already exists");
		}
		return flughafenRepository.insert(name, null);
	}

	@Override
	public void deleteFlughafenById(Long id) {
		if (id == null)
			throw new InvalidArgumentException("Id darf nicht null sein");
	}

}
