package com.chakra.root.hrm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chakra.root.hrm.model.UserLevel;
import com.chakra.root.hrm.repositories.UserLevelRepo;

@Service("userLevelService")
@Transactional
public class UserLevelServiceImpl implements UserLevelService {

	@Autowired
	private UserLevelRepo userLevelRepository;

	@Override
	public UserLevel findById(Long id) {
		return userLevelRepository.findOne(id);
	}

	@Override
	public UserLevel findByLevelName(String name) {
		return userLevelRepository.findByName(name);
	}

	@Override
	public void saveUserLevel(UserLevel userLevel) {
		userLevelRepository.save(userLevel);
	}

	@Override
	public void updateUserLevel(UserLevel userLevel) {
		saveUserLevel(userLevel);
	}

	@Override
	public void deleteUserLevelById(Long id) {
		userLevelRepository.delete(id);
	}

	@Override
	public void deleteAllUsersLevel() {
		userLevelRepository.deleteAll();
	}

	@Override
	public List<UserLevel> findAllUsersLevel() {
		return userLevelRepository.findAll();
	}

	@Override
	public boolean isUserLevelExist(UserLevel userLevel) {
		return findByLevelName(userLevel.getName()) != null;
	}

}
