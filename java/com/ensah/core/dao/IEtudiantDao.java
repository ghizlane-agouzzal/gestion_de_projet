package com.ensah.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensah.core.bo.Etudiant;

public interface IEtudiantDao extends JpaRepository<Etudiant, Long> {
	
		public Etudiant getEtudiantByCne(String cne);
	
}
