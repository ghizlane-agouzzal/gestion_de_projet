package com.ensah.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ensah.core.dao.ImoduleDao;
import com.ensah.core.services.IModuleService;

public class ModuleServiceImpl implements IModuleService{
	
	@Autowired
	ImoduleDao I ;
	

	@Override
	public void addModule(Module Module) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateModule(Module Module) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Module> getAllModule() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteModule(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Module getModuleById(Long id) {
		// TODO Auto-generated method stub
		return null;
	} 

	


}
