package com.ensah.core.services.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensah.core.bo.InscriptionAnnuelle;
import com.ensah.core.dao.IIsncriptionDao;
import com.ensah.core.services.InscriptionService;
@Service
public class InscriptionSericeImpl implements InscriptionService{

	
	@Autowired
	IIsncriptionDao In;
	@Override
	public List<InscriptionAnnuelle> GetAllInscription(int id) {
				
		return In.findAll();
		
				
	
	}

	public List<InscriptionAnnuelle> addInscription(List<InscriptionAnnuelle> L) {
          
		return In.saveAll(L);
	}

	@Override
	public void addInscription(InscriptionAnnuelle L) {
		In.save(L);
		
	}

	@Override
	public InscriptionAnnuelle getInscription(int id) {
		// TODO Auto-generated method stub
		return In.getById((long)id);
	}
	
	
	
	
	
	


}
