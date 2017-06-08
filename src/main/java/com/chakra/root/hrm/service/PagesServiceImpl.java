package com.chakra.root.hrm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chakra.root.hrm.model.Pages;
import com.chakra.root.hrm.repositories.PagesRepo;

@Service("pagesService")
@Transactional
public class PagesServiceImpl implements PagesService {

	@Autowired
	private PagesRepo pagesRepository;

	@Override
	public Pages findById(Long id) {
		return pagesRepository.findOne(id);
	}

	@Override
	public Pages findByPagesName(String name) {
		return pagesRepository.findByName(name);
	}

	@Override
	public void savePage(Pages page) {
		pagesRepository.save(page);
	}

	@Override
	public void updatePage(Pages page) {
		savePage(page);
	}

	@Override
	public void deletePageById(Long id) {
		pagesRepository.delete(id);
	}

	@Override
	public void deleteAllPages() {
		pagesRepository.deleteAll();
	}

	@Override
	public List<Pages> findAllPages() {
		return pagesRepository.findAll();
	}

	@Override
	public boolean isPageExist(Pages page) {
		return findByPagesName(page.getName()) != null;
	}

}
