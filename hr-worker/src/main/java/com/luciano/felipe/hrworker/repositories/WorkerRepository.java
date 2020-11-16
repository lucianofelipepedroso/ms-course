package com.luciano.felipe.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luciano.felipe.hrworker.entities.Worker;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
