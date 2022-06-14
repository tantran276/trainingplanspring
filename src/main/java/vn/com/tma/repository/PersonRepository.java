package vn.com.tma.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import vn.com.tma.entity.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{
	List<Person> findByFirstName(String firstName);
}
