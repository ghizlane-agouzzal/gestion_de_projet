package com.ensah.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensah.core.bo.InscriptionMatiere;
import com.ensah.core.dao.InscriptionMatiereDao;
import com.ensah.core.services.InscriptionMatiereService;

@Service

public class InscriptionMatierServiceImpl implements InscriptionMatiereService {

	@Autowired
	private InscriptionMatiereDao In;
	@Override
	public void addMatiere(InscriptionMatiere Niveau) {
		In.save(Niveau);
	}

	@Override
	public void updateInscMat(InscriptionMatiere Niveau) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<InscriptionMatiere> getAllInscMat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInscMat(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public InscriptionMatiere getInscMatById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


}
