package com.chakra.root.hrm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chakra.root.hrm.model.UserLevel;

@Repository
public interface UserLevelRepo extends JpaRepository<UserLevel, Long> {
	UserLevel findByName(String name);
}
