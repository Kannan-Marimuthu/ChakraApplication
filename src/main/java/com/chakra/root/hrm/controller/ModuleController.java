package com.chakra.root.hrm.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.chakra.root.common.util.ChakraErrorType;
import com.chakra.root.hrm.model.Module;
import com.chakra.root.hrm.service.ModuleService;

@RestController
@RequestMapping("/api")
public class ModuleController {

	public static final Logger logger = LoggerFactory.getLogger(ModuleController.class);

	@Autowired
	ModuleService moduleService;

	// -------------------Retrieve All Modules----------------
	@RequestMapping(value = "/module/", method = RequestMethod.GET)
	public ResponseEntity<List<Module>> listAllModules() {
		List<Module> modules = moduleService.findAllModules();
		if (modules.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Module>>(modules, HttpStatus.OK);
	}

	// -------------------Retrieve Single Module---------------
	@RequestMapping(value = "/module/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getModule(@PathVariable("id") long id) {
		logger.info("Fetching Module with id {}", id);
		Module module = moduleService.findById(id);
		if (module == null) {
			logger.error("Module with id {} not found.", id);
			return new ResponseEntity(
					new ChakraErrorType("Module with id " + id + " not found"),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Module>(module, HttpStatus.OK);
	}

	// -------------------Create a User--------------
	@RequestMapping(value = "/module/", method = RequestMethod.POST)
	public ResponseEntity<?> createModule(@RequestBody Module module,
			UriComponentsBuilder ucBuilder) {
		logger.info("Creating User : {}", module);

		if (moduleService.isModuleExist(module)) {
			logger.error("Unable to create. A Module with name {} already exist",
					module.getName());
			return new ResponseEntity(
					new ChakraErrorType("Unable to create. A Module with name "
							+ module.getName() + " already exist."),
					HttpStatus.CONFLICT);
		}
		moduleService.saveModule(module);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/module/{id}")
				.buildAndExpand(module.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a Module ----------------------
	@RequestMapping(value = "/module/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateModule(@PathVariable("id") long id,
			@RequestBody Module module) {
		logger.info("Updating Module with id {}", id);

		Module currentModule = moduleService.findById(id);

		if (currentModule == null) {
			logger.error("Unable to update. Module with id {} not found.", id);
			return new ResponseEntity(
					new ChakraErrorType(
							"Unable to upate. Module with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		currentModule.setName(module.getName());
		currentModule.setDesc(module.getDesc());
		moduleService.updateModule(currentModule);
		return new ResponseEntity<Module>(currentModule, HttpStatus.OK);
	}

	// ------------------- Delete a Module-------

	@RequestMapping(value = "/module/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteModule(@PathVariable("id") long id) {
		logger.info("Fetching & Deleting Module with id {}", id);

		Module module = moduleService.findById(id);
		if (module == null) {
			logger.error("Unable to delete. Module with id {} not found.", id);
			return new ResponseEntity(
					new ChakraErrorType(
							"Unable to delete. Module with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		moduleService.deleteModuleById(id);
		return new ResponseEntity<Module>(HttpStatus.NO_CONTENT);
	}

	// ------------------- Delete All Modules-----------------------------

	@RequestMapping(value = "/module/", method = RequestMethod.DELETE)
	public ResponseEntity<Module> deleteAllUsers() {
		logger.info("Deleting All Modules");

		moduleService.deleteAllModules();
		return new ResponseEntity<Module>(HttpStatus.NO_CONTENT);
	}

}
