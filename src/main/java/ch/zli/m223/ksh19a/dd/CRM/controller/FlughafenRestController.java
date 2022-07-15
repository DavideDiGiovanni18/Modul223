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

import ch.zli.m223.ksh19a.dd.CRM.service.LandService;

@RestController
@RequestMapping("/api/v3")
public class FlughafenRestController {

	@Autowired
	private LandService service;

	@GetMapping("/flughafen")
	List<FlughafenDto> getAllFlughafen() {
		return service.flughafenList().stream().map(flug -> new FlughafenDto(flug)).collect(Collectors.toList());
	}

	@PostMapping("/flughafen")
	FlughafenDto saveFlughafen(@RequestBody FlughafenInputDto flughafenData) {
		return new FlughafenDto(service.insertFlughafen(flughafenData.name));
	}

	@DeleteMapping("/flughafen/{id}")
	void deleteFlughafen(@PathVariable Long id) {
		service.deleteFlughafenById(id);
	}

}
