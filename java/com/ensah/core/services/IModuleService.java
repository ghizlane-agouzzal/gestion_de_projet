package com.ensah.core.services;

import java.util.List;

public interface IModuleService {

	
	public void addModule(Module Module);
	

	public void updateModule(Module Module);

	public List<Module> getAllModule();

	public void deleteModule(Long id);

	public Module getModuleById(Long id);
	

}
