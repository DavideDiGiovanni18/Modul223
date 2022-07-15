package ch.zli.m223.ksh19a.dd.CRM.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zli.m223.ksh19a.dd.CRM.service.LandService;

@RestController
@RequestMapping("/api/v2")
public class LandRestController {

	@Autowired
	public LandService laenderService;

	@GetMapping("/laender")
	List<LandDto> getLaender() {
		return laenderService.landList().stream().map(land -> new LandDto(land)).collect(Collectors.toList());
	}

	@GetMapping("/laender/{id}")
	LandDto getLand(@PathVariable("id") Long id) {
		return new LandDto(laenderService.getLandById(id));
	}

	@GetMapping("/laender/{id}/flughafen")
	List<FlughafenDto> getFlughafenInLaender(@PathVariable("id") long id) {
		var land = laenderService.getLandById(id);
		return land.getFlughafen().stream().map(r -> new FlughafenDto(r)).collect(Collectors.toList());
	}

}
