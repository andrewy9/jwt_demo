package com.andrew.jwt_demo;

import com.andrew.jwt_demo.domain.AppUser;
import com.andrew.jwt_demo.domain.Role;
import com.andrew.jwt_demo.service.AppUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class JwtDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtDemoApplication.class, args);
	}

	@Bean
	CommandLineRunner run(AppUserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveAppUser(new AppUser(null, "John Travolta", "John", "1234", new ArrayList<>()));
			userService.saveAppUser(new AppUser(null, "James Morrison", "James", "1234", new ArrayList<>()));
			userService.saveAppUser(new AppUser(null, "Judy Dayson", "Judy", "1234", new ArrayList<>()));
			userService.saveAppUser(new AppUser(null, "Jill Fysure", "Jill", "1234", new ArrayList<>()));

			userService.addRoleToAppUser("John", "ROLE_USER");
			userService.addRoleToAppUser("John", "ROLE_MANAGER");
			userService.addRoleToAppUser("James", "ROLE_MANAGER");
			userService.addRoleToAppUser("Judy", "ROLE_ADMIN");
			userService.addRoleToAppUser("Jill", "ROLE_USER");
			userService.addRoleToAppUser("Jill", "ROLE_ADMIN");
			userService.addRoleToAppUser("Jill", "ROLE_SUPER_ADMIN");

		};
	}
}
