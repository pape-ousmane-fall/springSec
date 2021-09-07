package com.mapsn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mapsn.entities.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Long> {
public AppUser findByUsername(String name);
}
