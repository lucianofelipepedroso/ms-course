package com.luciano.felipe.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luciano.felipe.hrworker.entities.Worker;
import com.luciano.felipe.hrworker.repositories.WorkerRepository;

@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerResources {

	private static Logger logger = LoggerFactory.getLogger(WorkerResources.class);

	@Autowired
	private WorkerRepository workerRepository;

	@Autowired
	private Environment environment;

    @Value("${test.config}")
    private String testConfig;
    
	@GetMapping(value = "/configs")
	public ResponseEntity<Void> getConfig() {
		logger.info(testConfig);
		return ResponseEntity.noContent().build();

	}

	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> list = workerRepository.findAll();
		return ResponseEntity.ok(list);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id) {
		logger.info("PORT:=>" + environment.getProperty("local.server.port"));
		Worker worker = workerRepository.findById(id).get();
		return ResponseEntity.ok(worker);

	}

}
