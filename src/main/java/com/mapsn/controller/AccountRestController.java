package com.mapsn.controller;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mapsn.entities.AppUser;
import com.mapsn.services.AccountService;

@RestController
public class AccountRestController {
	@Autowired
	private AccountService accountService;
	@PostMapping("/register")
	public AppUser register(@RequestBody RegisterForm userForm) {
		if(!userForm.getPassword().equals(userForm.getRepassword())) 
			throw new RuntimeException("you must confirm your password");
		AppUser appUser=accountService.findUserByUserName(userForm.getUsername());
		if(appUser!=null)throw new RuntimeException("this user already exixts");
			AppUser user=new AppUser();
			user.setUsername(userForm.getUsername());
			user.setPassword(userForm.getPassword());
			 accountService.save(user);
			 accountService.addRoleToUser(userForm.getUsername(), "USER");
			 return user;
		

	}

}
