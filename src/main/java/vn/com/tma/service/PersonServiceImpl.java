package vn.com.tma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.tma.entity.Person;
import vn.com.tma.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService{

	@Autowired
	PersonRepository personRepository;

	@Override
	public List<Person> getPersons() {
		return (List<Person>) personRepository.findAll();
	}

	@Override
	public List<Person> findByFirstName(String firstName) {
		return personRepository.findByFirstName(firstName);
	}

}
