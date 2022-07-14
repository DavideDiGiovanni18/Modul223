package ch.zli.m223.ksh19a.dd.CRM.init;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import ch.zli.m223.ksh19a.dd.CRM.model.AppUser;
import ch.zli.m223.ksh19a.dd.CRM.model.Flughafen;
import ch.zli.m223.ksh19a.dd.CRM.model.Laender;
import ch.zli.m223.ksh19a.dd.CRM.repository.FlughafenRepository;
import ch.zli.m223.ksh19a.dd.CRM.repository.LaenderRepository;
import ch.zli.m223.ksh19a.dd.CRM.repository.RoleRepository;
import ch.zli.m223.ksh19a.dd.CRM.repository.UserRepository;
import ch.zli.m223.ksh19a.dd.CRM.roles.AppRoles;

@Component
public class ServerInitializer implements ApplicationRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private LaenderRepository laenderRepository;

	@Autowired
	private FlughafenRepository flughafenRepository;

	@Override
	@Transactional
	public void run(ApplicationArguments args) throws Exception {

		Laender land = laenderRepository.insert("Schweiz");
		Laender land2 = laenderRepository.insert("Italien");// Laender
		Flughafen eins = flughafenRepository.insert("Flughafen Zürich", land);// Flughafen

		AppUser max = userRepository.insert("Max", "max", eins);// User
		roleRepository.insert(AppRoles.ADMIN, max);
		roleRepository.insert(AppRoles.USER, max);

		AppUser trax = userRepository.insert("Trax", "trax", eins);
		roleRepository.insert(AppRoles.USER, trax);

	}
}
