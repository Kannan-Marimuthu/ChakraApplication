package com.chakra.root.hrm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chakra.root.hrm.model.Module;

@Repository
public interface ModuleRepo extends JpaRepository<Module, Long> {
	Module findByName(String name);
}
