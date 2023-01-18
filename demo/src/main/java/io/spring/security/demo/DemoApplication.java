package io.spring.security.demo;

import io.spring.security.demo.entity.Role;
import io.spring.security.demo.entity.User;
import io.spring.security.demo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "John Traveloka", "john", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Car Uber", "car", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Grab Food", "grab", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Go Jek", "go", "1234", new ArrayList<>()));

			userService.addRoleToUser("john", "ROLE_USER");
			userService.addRoleToUser("john", "ROLE_MANAGER");
			userService.addRoleToUser("car", "ROLE_MANAGER");
			userService.addRoleToUser("grab", "ROLE_ADMIN");
			userService.addRoleToUser("go", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("go", "ROLE_ADMIN");
			userService.addRoleToUser("go", "ROLE_USER");

		};
	}
}
