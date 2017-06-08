package com.chakra.root.hrm.service;

import java.util.List;

import com.chakra.root.hrm.model.Module;

public interface ModuleService {

	Module findById(Long id);

	Module findByModuleName(String name);

	void saveModule(Module module);

	void updateModule(Module module);

	void deleteModuleById(Long id);

	void deleteAllModules();

	List<Module> findAllModules();

	boolean isModuleExist(Module module);
}