package ch.zli.m223.ksh19a.dd.CRM.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ch.zli.m223.ksh19a.dd.CRM.model.AppUser;
import ch.zli.m223.ksh19a.dd.CRM.model.Flughafen;
import ch.zli.m223.ksh19a.dd.CRM.service.LandService;
import ch.zli.m223.ksh19a.dd.CRM.service.UserService;

@Controller
public class UserWebController {

	@Autowired
	private UserService userService;

	@Autowired
	private LandService landService;

	@GetMapping("/userlist")
	String getUserList(Model model) {
		List<AppUser> userList = userService.getAllUser();
		model.addAttribute("users", userList);
		return "userList";
	}

	@GetMapping("/flughafenList")
	String getFlughafenList(Model model) {
		List<Flughafen> flughafenList = landService.flughafenList();
		model.addAttribute("flughafen", flughafenList);
		return "flughafenList";
	}

	@GetMapping("/admin")
	String goToAdminPage() {
		return "admin_page";
	}

	@GetMapping("/passagier")
	String goToUserPage() {
		return "user_page";
	}

	@GetMapping("/logedin")
	String gotoLoggedIn() {
		return "loged_in_page";
	}
}
