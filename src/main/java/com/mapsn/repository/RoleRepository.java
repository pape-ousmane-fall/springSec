package com.mapsn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mapsn.entities.AppRole;

public interface RoleRepository extends JpaRepository<AppRole, Long> {
	public AppRole findByRoleName(String roleName);
}
