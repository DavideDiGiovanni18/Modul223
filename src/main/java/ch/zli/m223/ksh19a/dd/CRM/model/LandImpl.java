package ch.zli.m223.ksh19a.dd.CRM.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "Laender")
public class LandImpl implements Land {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(unique = true)
	private String land;

	@OneToMany(mappedBy = "laender", cascade = CascadeType.ALL)
	private List<FlughafenImpl> flughaefen;

	protected LandImpl() {
		/* for JPA only */
		flughaefen = new ArrayList<>();
	}

	public LandImpl(String land) {
		this();
		this.land = land;
	}

	@Override
	public long getId() {
		return id;
	}

	@Override
	public String getLand() {
		return land;
	}

	@Override
	public List<Flughafen> getFlughafen() {
		return new ArrayList<>(flughaefen);
	}

	public void addFlughafenToList(FlughafenImpl newFlughafen) {
		flughaefen.add(newFlughafen);

	}

}
