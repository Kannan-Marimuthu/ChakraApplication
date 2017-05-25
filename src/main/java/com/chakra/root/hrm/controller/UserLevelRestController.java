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
import com.chakra.root.hrm.model.User;
import com.chakra.root.hrm.model.UserLevel;
import com.chakra.root.hrm.service.UserLevelService;

@RestController
@RequestMapping("/api")
public class UserLevelRestController {

	public static final Logger logger = LoggerFactory
			.getLogger(UserLevelRestController.class);

	@Autowired
	UserLevelService userLevelService; // Service which will do all data
										// retrieval/manipulation work

	// -------------------Retrieve All UserLevel-------
	@RequestMapping(value = "/userLevel/", method = RequestMethod.GET)
	public ResponseEntity<List<UserLevel>> listAllUsers() {
		List<UserLevel> userLevel = userLevelService.findAllUsersLevel();
		if (userLevel.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<UserLevel>>(userLevel, HttpStatus.OK);
	}

	// -------------------Retrieve Single UserLevel-----------

	@RequestMapping(value = "/userLevel/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserLevel> getUser(@PathVariable("id") long id) {
		logger.info("Fetching User with id {}", id);
		UserLevel userLevel = userLevelService.findById(id);
		if (userLevel == null) {
			logger.error("User with id {} not found.", id);
			return new ResponseEntity(
					new ChakraErrorType("User with id " + id + " not found"),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<UserLevel>(userLevel, HttpStatus.OK);
	}

	// -------------------Create a User Level-------------------------------------------

	@RequestMapping(value = "/userLevel/", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody UserLevel userLevel,
			UriComponentsBuilder ucBuilder) {
		logger.info("Creating User : {}", userLevel);

		if (userLevelService.isUserLevelExist(userLevel)) {
			logger.error("Unable to create. A User with name {} already exist",
					userLevel.getName());
			return new ResponseEntity(
					new ChakraErrorType("Unable to create. A User with name "
							+ userLevel.getName() + " already exist."),
					HttpStatus.CONFLICT);
		}
		userLevelService.saveUserLevel(userLevel);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/userLevel/{id}")
				.buildAndExpand(userLevel.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a User ------------------------------------------------

	@RequestMapping(value = "/userLevel/{id}", method = RequestMethod.PUT)
	public ResponseEntity<UserLevel> updateUser(@PathVariable("id") long id,
			@RequestBody UserLevel userLevel) {
		logger.info("Updating User with id {}", id);

		UserLevel currentUserLevel = userLevelService.findById(id);

		if (currentUserLevel == null) {
			logger.error("Unable to update. User with id {} not found.", id);
			return new ResponseEntity(
					new ChakraErrorType(
							"Unable to upate. User with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		currentUserLevel.setName(userLevel.getName());
		currentUserLevel.setDesc(userLevel.getDesc());
		userLevelService.updateUserLevel(currentUserLevel);
		return new ResponseEntity<UserLevel>(currentUserLevel, HttpStatus.OK);
	}

	// ------------------- Delete a User Level-----------------------------------------

	@RequestMapping(value = "/userLevel/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {
		logger.info("Fetching & Deleting User Level with id {}", id);

		UserLevel userLevel = userLevelService.findById(id);
		if (userLevel == null) {
			logger.error("Unable to delete. User Level with id {} not found.", id);
			return new ResponseEntity(
					new ChakraErrorType(
							"Unable to delete. User Level with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		userLevelService.deleteUserLevelById(id);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}

	// ------------------- Delete All User Levels-----------------------------

	@RequestMapping(value = "/userLevel/", method = RequestMethod.DELETE)
	public ResponseEntity<User> deleteAllUsers() {
		logger.info("Deleting All User Levels");

		userLevelService.deleteAllUsersLevel();
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}

}
