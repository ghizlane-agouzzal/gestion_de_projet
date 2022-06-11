package com.ensah.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensah.core.bo.InscriptionModule;
import com.ensah.core.dao.InscriptionModuleDao;
import com.ensah.core.services.InscriptionModuleService;
@Service
public class InscriptionModuleImpl implements InscriptionModuleService {
	@Autowired
	InscriptionModuleDao M;

	@Override
	public void addInscModule(InscriptionModule mod) {
             		M.save(mod);
	}

	@Override
	public void updateInscMat(InscriptionModule Niveau) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<InscriptionModule> getAllInscMat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInscMat(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public InscriptionModule getInscMatById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
