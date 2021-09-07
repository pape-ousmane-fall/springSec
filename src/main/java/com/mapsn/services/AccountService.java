package com.mapsn.services;

import com.mapsn.entities.AppRole;
import com.mapsn.entities.AppUser;

public interface AccountService {

	public AppUser save(AppUser user);
	public AppRole save(AppRole role);
	public void addRoleToUser(String userName,String roleName);
	public AppUser findUserByUserName(String username);
}
