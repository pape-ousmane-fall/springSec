package com.mapsn;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.mapsn.entities.AppRole;
import com.mapsn.entities.AppUser;
import com.mapsn.entities.Task;
import com.mapsn.repository.ITaskRepository;
import com.mapsn.services.AccountService;

@SpringBootApplication
public class JwtSpringSecApplication implements CommandLineRunner{
@Autowired
	private ITaskRepository iTaskRepository;
@Autowired
private AccountService accountService;
	public static void main(String[] args) {
		SpringApplication.run(JwtSpringSecApplication.class, args);
	}
	@Bean
public BCryptPasswordEncoder getBCPE() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		accountService.save(new AppUser(null,"admin","1234",null));
		accountService.save(new AppUser(null,"user","1234",null));
		
		accountService.save(new AppRole(null,"ADMIN"));
		accountService.save(new AppRole(null,"USER"));
		
		accountService.addRoleToUser("admin", "ADMIN");
		accountService.addRoleToUser("user", "USER");
		
		Stream.of("T1","T2","T3","T4").forEach(t->{
			iTaskRepository.save(new Task(null,t));
		});
		iTaskRepository.findAll().forEach(t->{
			System.out.println(t.getTaskName());
		});
	}

}
