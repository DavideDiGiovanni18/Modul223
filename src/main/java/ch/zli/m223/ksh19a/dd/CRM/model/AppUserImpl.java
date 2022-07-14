package ch.zli.m223.ksh19a.dd.CRM.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SuppressWarnings("serial")
@Entity(name = "AppUser")
public class AppUserImpl implements AppUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String name;

	@ManyToOne
	private FlughafenImpl flughafen;

	@OneToMany(mappedBy = "appUser", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<RoleImpl> roles;

	private String passwordHash;

	protected AppUserImpl() {
		/* for JPA only */
		roles = new ArrayList<>();
	}

	public AppUserImpl(String name, String password, FlughafenImpl flughafen) {
		this();
		this.name = name;
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		this.passwordHash = encoder.encode(password);
		this.flughafen = flughafen;
	}

	@Override
	public Long getID() {
		return id;
	}

	@Override
	public String getEmail() {
		return name;
	}

	@Override
	public List<Role> getRoles() {
		return new ArrayList<>(roles);
	}

	public void addRoleToList(RoleImpl newRole) {
		roles.add(newRole);

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {// Benutzer will wissen welche Rolle er hat
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return passwordHash;
	}

	@Override
	public String getUsername() {
		return getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {// Rechte noch gültig
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
