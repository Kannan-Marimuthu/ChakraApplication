package com.chakra.root.hrm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chakra.root.hrm.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

	User findByName(String name);

}
