package ch.zli.m223.ksh19a.dd.CRM.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zli.m223.ksh19a.dd.CRM.service.LaenderService;

@RestController
@RequestMapping("/api/v3")
public class FlughafenRestController {

	@Autowired
	private LaenderService service;

	@GetMapping("/flughafen")
	List<FlughafenDto> getAllUsers() {
		return service.flughafenList().stream().map(user -> new FlughafenDto(user)).collect(Collectors.toList());
	}

}
