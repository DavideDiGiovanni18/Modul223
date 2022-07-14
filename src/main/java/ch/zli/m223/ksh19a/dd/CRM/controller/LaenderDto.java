package ch.zli.m223.ksh19a.dd.CRM.controller;

import java.util.ArrayList;
import java.util.List;

import ch.zli.m223.ksh19a.dd.CRM.model.Laender;

public class LaenderDto {
	public Long id;
	public String laend;
	public List<String> flughafenList;
	public List<String> userList;

	public LaenderDto(Laender laender) {
		id = laender.getId();
		laend = laender.getLand();
		flughafenList = new ArrayList<>();
		flughafenList = new ArrayList<>();
		for (var flughafen : laender.getFlughafen()) {
			flughafenList.add(flughafen.getName());
			for (var user : flughafen.getUser()) {
				userList.add(user.getEmail());
			}
		}
	}

}
