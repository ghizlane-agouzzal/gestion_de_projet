package com.ensah.core.services;

import java.util.List;

import com.ensah.core.bo.InscriptionModule;

public interface InscriptionModuleService {
	public void addInscModule(InscriptionModule mod);

	public void updateInscMat(InscriptionModule Niveau);

	public List<InscriptionModule> getAllInscMat();

	public void deleteInscMat(Long id);

	public InscriptionModule getInscMatById(Long id);
	
	

}
