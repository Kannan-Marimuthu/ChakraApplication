package com.chakra.root.hrm.service;

import java.util.List;

import com.chakra.root.hrm.model.UserLevel;

public interface UserLevelService {

	UserLevel findById(Long id);

	UserLevel findByLevelName(String name);

	void saveUserLevel(UserLevel userLevel);

	void updateUserLevel(UserLevel userLevel);

	void deleteUserLevelById(Long id);

	void deleteAllUsersLevel();

	List<UserLevel> findAllUsersLevel();

	boolean isUserLevelExist(UserLevel userLevel);
}