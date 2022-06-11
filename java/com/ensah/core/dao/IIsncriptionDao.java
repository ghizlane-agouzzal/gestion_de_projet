package com.ensah.core.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensah.core.bo.Etudiant;
import com.ensah.core.bo.InscriptionAnnuelle;

public interface IIsncriptionDao extends JpaRepository<InscriptionAnnuelle, Long>{

	
	public List<InscriptionAnnuelle> findAllByEtudiant(Etudiant Etudiant);
	



}
