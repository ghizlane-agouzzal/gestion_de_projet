package com.ensah.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensah.core.bo.Niveau;
import com.ensah.core.dao.IniveauDao;
import com.ensah.core.services.INiveauService;
@Service
public class NiveauServiceImpl implements INiveauService  {

	@Autowired
	IniveauDao N;
	@Override
	public void addNiveau(Niveau Niveau) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateNiveau(Niveau Niveau) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Niveau> getAllNiveau() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteNiveau(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Niveau getNIveauById(int id) {
		// TODO Auto-generated method stub
		return N.getById((long) id);
	}

 

}
