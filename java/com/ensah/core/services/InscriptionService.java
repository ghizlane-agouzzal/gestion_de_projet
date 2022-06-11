package com.ensah.core.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ensah.core.bo.InscriptionAnnuelle;
@Service
public interface InscriptionService {
	public List<InscriptionAnnuelle> GetAllInscription(int id);
	public InscriptionAnnuelle getInscription(int id);
	public void addInscription(InscriptionAnnuelle L);
	

}
