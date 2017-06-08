package com.chakra.root.hrm.service;

import java.util.List;

import com.chakra.root.hrm.model.Pages;

public interface PagesService {

	Pages findById(Long id);

	Pages findByPagesName(String name);

	void savePage(Pages page);

	void updatePage(Pages page);

	void deletePageById(Long id);

	void deleteAllPages();

	List<Pages> findAllPages();

	boolean isPageExist(Pages page);
}