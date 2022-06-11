package com.ensah.core.services;

import java.util.List;

import com.ensah.core.bo.Niveau;

public interface INiveauService {
	public void addNiveau(Niveau Niveau);

	public void updateNiveau(Niveau Niveau);

	public List<Niveau> getAllNiveau();

	public void deleteNiveau(int id);

	public Niveau getNIveauById(int nu);

}
