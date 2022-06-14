package vn.com.tma.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import vn.com.tma.repository.PersonRepository;

@Component
public class InitUtils {

	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void initPersons() {
		 Long max = personRepository.count();
		jdbcTemplate.execute("INSERT INTO public.person(\r\n"
				+ "id, first_name, last_name)\r\n"
				+ "	VALUES ("+ ++max + ",  'A', 'Tran')");
		jdbcTemplate.execute("INSERT INTO public.person(\r\n"
				+ "id, first_name, last_name)\r\n"
				+ "	VALUES ("+ ++max +", 'B', 'Nguyen')");
		jdbcTemplate.execute("INSERT INTO public.person(\r\n"
				+ "id, first_name, last_name)\r\n"
				+ "	VALUES ("+ ++max + ", 'C', 'Le')");
	}
}
