package vn.com.tma.service;

import java.util.List;

import vn.com.tma.entity.Person;

public interface PersonService {

	List<Person> getPersons();
	List<Person> findByFirstName(String firstName);
}
