package ch.zli.m223.ksh19a.dd.CRM.model;

import java.util.List;

public interface Laender {

	public long getId();

	public String getLand();

	public List<Flughafen> getFlughafen();
}
