package com.mapsn.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mapsn.entities.AppRole;
import com.mapsn.entities.AppUser;
import com.mapsn.repository.RoleRepository;
import com.mapsn.repository.UserRepository;
@Service
@Transactional
public class AccountServiceImpl implements AccountService {
 
	@Autowired
private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
 private UserRepository userRepository;
	@Autowired
 private RoleRepository roleRepository;


	@Override
	public AppUser save(AppUser user) {
		// TODO Auto-generated method stub
		String hashPw=bCryptPasswordEncoder.encode(user.getUsername());
		user.setPassword(hashPw);
		return userRepository.save(user);
	}

	@Override
	public AppRole save(AppRole role) {
		// TODO Auto-generated method stub
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String userName, String roleName) {
		// TODO Auto-generated method stub
		AppRole role=roleRepository.findByRoleName(roleName);
		AppUser user=userRepository.findByUsername(userName);
		user.getRoles().add(role);
	}

	@Override
	public AppUser findUserByUserName(String username) {
		// TODO Auto-generated method stub
		
		return userRepository.findByUsername(username);
	}

}
