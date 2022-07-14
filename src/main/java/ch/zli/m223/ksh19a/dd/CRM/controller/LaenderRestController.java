package ch.zli.m223.ksh19a.dd.CRM.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zli.m223.ksh19a.dd.CRM.service.LaenderService;

@RestController
@RequestMapping("/api/v2")
public class LaenderRestController {

	@Autowired
	public LaenderService laenderService;

	@GetMapping("/laender")
	List<LaenderDto> getLaender() {
		return laenderService.landList().stream().map(land -> new LaenderDto(land)).collect(Collectors.toList());
	}

	@GetMapping("/laender/{id}")
	LaenderDto getLand(@PathVariable("id") Long id) {
		return new LaenderDto(laenderService.getLandById(id));
	}

	@GetMapping("/laender/{id}/flughafen")
	List<FlughafenDto> getFlughfaenInLaender(@PathVariable("id") long id) {
		var land = laenderService.getLandById(id);
		return land.getFlughafen().stream().map(r -> new FlughafenDto(r)).collect(Collectors.toList());
	}

}
