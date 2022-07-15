package ch.zli.m223.ksh19a.dd.CRM.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zli.m223.ksh19a.dd.CRM.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserRestController {
	// private List<AppUser> users = new ArrayList<AppUser>(Arrays.asList(new
	// AppUserImpl("Max"),new AppUserImpl("Dave")));
	/*
	 * AppUserImpl[] userArray = {new AppUserImpl("Max"),new AppUserImpl("Dave")};
	 * List<AppUserImpl> appUsers = Arrays.asList(userArray);
	 */

	@Autowired
	private UserService userService;

	@GetMapping("/admin")
	List<UserDto> getAllUsers() {
		// todo get List from service Layer
		return userService.getAllUser().stream().map(user -> new UserDto(user)).collect(Collectors.toList());
	}

	@GetMapping("/admin/{id}")
	UserDto getUser(@PathVariable("id") long id) {// suche im Pfad eine variable mit ID, nimm Wert und erstelle eine
													// long
		return new UserDto(userService.getUser(id));
	}

	@PostMapping("/admin")
	UserDto insertUser(@RequestBody UserInputDto userData) {
		return new UserDto(userService.insertUser(userData.name, userData.password));
	}

	@DeleteMapping("/admin/{id}")
	void deleteUser(@PathVariable("id") Long id) {
		userService.deleteUserById(id);
	}

	@GetMapping("/admin/{id}/roles")
	List<RoleDto> getRolesForUser(@PathVariable("id") long id) {
		var user = userService.getUser(id);
		return user.getRoles().stream().map(r -> new RoleDto(r)).collect(Collectors.toList());
	}
}
