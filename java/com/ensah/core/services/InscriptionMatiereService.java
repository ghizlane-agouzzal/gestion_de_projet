package com.ensah.core.services;

import java.util.List;

import com.ensah.core.bo.InscriptionMatiere;

public interface InscriptionMatiereService {

	public void addMatiere(InscriptionMatiere Niveau);

	public void updateInscMat(InscriptionMatiere Niveau);

	public List<InscriptionMatiere> getAllInscMat();

	public void deleteInscMat(Long id);

	public InscriptionMatiere getInscMatById(Long id);
	
	

}
