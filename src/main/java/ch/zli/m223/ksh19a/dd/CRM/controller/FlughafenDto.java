package ch.zli.m223.ksh19a.dd.CRM.controller;

import java.util.ArrayList;
import java.util.List;

import ch.zli.m223.ksh19a.dd.CRM.model.Flughafen;

public class FlughafenDto {
	public Long id;
	public String name;
	public List<String> usersList;

	public FlughafenDto(Flughafen hafen) {
		id = hafen.getId();
		name = hafen.getName();
		usersList = new ArrayList<>();
		for (var user : hafen.getUser()) {
			usersList.add(user.getEmail());
		}
	}

}
