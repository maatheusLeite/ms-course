package com.matheusleite.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.matheusleite.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
	
}
