package com.chakra.root.hrm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chakra.root.hrm.model.Pages;

@Repository
public interface PagesRepo extends JpaRepository<Pages, Long> {
	Pages findByName(String name);
}
