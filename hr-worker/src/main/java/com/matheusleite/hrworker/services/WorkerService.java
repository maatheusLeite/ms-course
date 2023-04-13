package com.matheusleite.hrworker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusleite.hrworker.entities.Worker;
import com.matheusleite.hrworker.repositories.WorkerRepository;
import com.matheusleite.hrworker.services.excetions.ResourceNotFoundException;

@Service
public class WorkerService {

	@Autowired
	private WorkerRepository repository;
	
	public List<Worker> findAll() {
		return repository.findAll();
	}
	
	public Worker findById(Long id) {
		Optional<Worker> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
}
