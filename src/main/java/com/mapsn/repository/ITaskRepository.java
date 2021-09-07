package com.mapsn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mapsn.entities.Task;

public interface ITaskRepository extends JpaRepository<Task, Long> {

}
