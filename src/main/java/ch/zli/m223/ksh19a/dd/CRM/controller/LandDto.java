package ch.zli.m223.ksh19a.dd.CRM.controller;

import java.util.ArrayList;
import java.util.List;

import ch.zli.m223.ksh19a.dd.CRM.model.Land;

public class LandDto {
	public Long id;
	public String laend;
	public List<String> flughafenList;

	public LandDto(Land laender) {
		id = laender.getId();
		laend = laender.getLand();
		flughafenList = new ArrayList<>();
		for (var flughafen : laender.getFlughafen()) {
			flughafenList.add(flughafen.getName());
		}
	}
}
