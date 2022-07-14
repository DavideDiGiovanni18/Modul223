package ch.zli.m223.ksh19a.dd.CRM.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "Flughafen")
public class FlughafenImpl implements Flughafen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	public String name;

	@ManyToOne
	public LaenderImpl laender;

	@OneToMany(mappedBy = "flughafen", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<AppUserImpl> users;

	protected FlughafenImpl() {
		/**/
	}

	public FlughafenImpl(String name, LaenderImpl laender) {
		this.name = name;
		this.laender = laender;
		users = new ArrayList<>();
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public List<AppUser> getUser() {
		return new ArrayList<>(users);
	}

	@Override
	public void addUserToList(AppUserImpl newAppUser) {
		users.add(newAppUser);
	}

}
