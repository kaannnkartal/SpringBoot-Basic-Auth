package com.folksdev.security.basic.auth;

import com.folksdev.security.basic.auth.dto.CreateUserRequest;
import com.folksdev.security.basic.auth.model.Role;
import com.folksdev.security.basic.auth.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class BasicAuthApplication implements CommandLineRunner {

	private final UserService userService;

	public BasicAuthApplication(UserService userService) {
		this.userService = userService;
	}


	public static void main(String[] args) {
		SpringApplication.run(BasicAuthApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		createDummyData();
	}


	private void createDummyData(){
		CreateUserRequest request = CreateUserRequest.builder()
				.name("Kaan")
				.username("Kaan")
				.password("pass")
				.authorities(Set.of(Role.ROLE_KAAN))
				.build();

		userService.createUser(request);


		CreateUserRequest request2 = CreateUserRequest.builder()
				.name("Mecit")
				.username("Kaann")
				.password("pass")
				.authorities(Set.of(Role.ROLE_USER))
				.build();

		userService.createUser(request2);

		CreateUserRequest request3 = CreateUserRequest.builder()
				.name("Mecit Kaan")
				.username("Kaannn")
				.password("pass")
				.authorities(Set.of(Role.ROLE_ADMIN))
				.build();

		userService.createUser(request3);
	}
}
