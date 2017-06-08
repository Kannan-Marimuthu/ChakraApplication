package com.chakra.root.hrm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chakra.root.hrm.model.Module;
import com.chakra.root.hrm.repositories.ModuleRepo;

@Service("moduleService")
@Transactional
public class ModuleServiceImpl implements ModuleService {

	@Autowired
	private ModuleRepo moduleRepository;

	@Override
	public Module findById(Long id) {
		return moduleRepository.findOne(id);
	}

	@Override
	public Module findByModuleName(String name) {
		return moduleRepository.findByName(name);
	}

	@Override
	public void saveModule(Module module) {
		moduleRepository.save(module);
	}

	@Override
	public void updateModule(Module module) {
		saveModule(module);
	}

	@Override
	public void deleteModuleById(Long id) {
		moduleRepository.delete(id);
	}

	@Override
	public void deleteAllModules() {
		moduleRepository.deleteAll();
	}

	@Override
	public List<Module> findAllModules() {
		return moduleRepository.findAll();
	}

	@Override
	public boolean isModuleExist(Module module) {
		return findByModuleName(module.getName()) != null;
	}

}
