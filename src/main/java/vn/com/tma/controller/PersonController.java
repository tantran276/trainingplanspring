package vn.com.tma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.com.tma.entity.Person;
import vn.com.tma.service.PersonService;
import vn.com.tma.utils.InitUtils;

@RestController("")
public class PersonController {

	@Autowired
	InitUtils initUtils;
	
	@Autowired
	PersonService personService;
	
	@GetMapping("/init")
	public ResponseEntity<List<Person>> initPersons() {
		initUtils.initPersons();
		return ResponseEntity.ok(personService.getPersons());
	}
	
	@GetMapping("/getpersons")
	public ResponseEntity<List<Person>> getPersons() {
		return ResponseEntity.ok(personService.getPersons());
	}
	
	@GetMapping("/findbyfirstname")
	public ResponseEntity<?> findPersonByFirstName(
			@RequestParam(name = "firstName") String firstName) {
		List<Person> persons = personService.findByFirstName(firstName);
		if(persons.isEmpty()) {
			return ResponseEntity.badRequest().body("No have person with first"
					+ " name is: " + firstName);
		} else {
			return ResponseEntity.ok(persons);
		}
	}
}
