package com.ensah.core.services;



import java.util.List;


import com.ensah.core.bo.Etudiant;

public interface IEtudiantService {
	public void addEtudiant(Etudiant etd);

	public void updateEtudiant(Etudiant etd);

	public List<Etudiant> getAllEtudiants();

	public void deleteEtudiant(Long id);

	public Etudiant getEtudiantById(Long id);
	
	public Etudiant getEtudiantByCin(String cin);

	Etudiant getEtudiantByCne(String cne);
	
	

	
}
