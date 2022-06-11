package com.ensah.core.services.impl;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ensah.core.bo.Etudiant;
import com.ensah.core.bo.Niveau;
import com.ensah.core.dao.IEtudiantDao;
import com.ensah.core.dao.IUtilisateurDao;
import com.ensah.core.services.IEtudiantService;
import com.ensah.core.utils.ExcelImporter;
@Service
@Transactional

public class EtudiantServiceImpl implements IEtudiantService{

	
	@Autowired
	IEtudiantDao ETD;
	@Override
	public void addEtudiant(Etudiant etd) {
		ETD.save(etd);
	}

	@Override
	public void updateEtudiant(Etudiant etd) {
				ETD.save(etd);		
	}

	@Override
	public List<Etudiant> getAllEtudiants() {
		// TODO Auto-generated method stub
		return ETD.findAll();
	}

	@Override
	public void deleteEtudiant(Long id) {
		ETD.deleteById(id);
	}

	@Override
	public Etudiant getEtudiantById(Long id) {
		// TODO Auto-generated method stub
		return ETD.getById(id);
	}

	@Override
	public Etudiant getEtudiantByCin(String cne) {
		// TODO Auto-generated method stub
		return ETD.getEtudiantByCne(cne	);
	}

	@Override
	public Etudiant getEtudiantByCne(String cne) {
		// TODO Auto-generated method stub
		return  ETD.getEtudiantByCne(cne	);
	}

//
//	@Autowired
//	private IEtudiantDao personDao;
//	@Autowired
//	private EtudiantServiceImpl etdDao;
//	@Override
//	public List<Etudiant> getAllPerson() {
//			return personDao.findAll();
//	}
//	public void deletePerson(Long id) {
//		personDao.deleteById(id);
//
//	}
//
//	public Etudiant getPersonById(Long id) {
//		return personDao.getById(id);
//
//	}
//
//	public void addStudent(Etudiant pPerson) {
//		personDao.save(pPerson);
//
//	}
//
//	public void updateStudent(Etudiant pPerson) {
//		personDao.save(pPerson);
//
//	}
//
//    @Override
//	public Etudiant getPersonByCne(String cne) {
//
//		return personDao.getEntityByColValue(Etudiant.class, "cne", cne);
//
//	}
//	@Override
//	public Niveau getNIveauById(Long id) {
//		 return .getById(id);
//		
//	}
//	@Override
//	public void addEtudiant(Etudiant etd) {
//		// TODO Auto-generated method stub
//		
//	}
//	@Override
//	public void updateEtudiant(Etudiant etd) {
//		// TODO Auto-generated method stub
//		
//	}
//	@Override
//	public List<Etudiant> getAllEtudiants() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	@Override
//	public void deleteEtudiant(Long id) {
//		// TODO Auto-generated method stub
//		
//	}
//	@Override
//	public Etudiant getEtudiantById(Long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	@Override
//	public Etudiant getEtudiantByCin(String cin) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	@Override
//	public Etudiant getEtudiantByCne(String cne) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
////	public  ArrayList<Student> InsEtudiant(MultipartFile is) throws IOException{
////		ExcelImporter tf=new ExcelImporter();
////		ArrayList<Student> listInsc=new ArrayList<Student>();
////        ArrayList<Student> listReInsc=new ArrayList<Student>();
////		List<Etudiant> ts=new ArrayList<Etudiant>();
////		ts.addAll(etdDao.getAllPerson());
////		List<Student> tr=tf.retenueFileExcel(is.getInputStream());
////		for(Student elem:tr) {
////			if(ts.contains(elem.getId())){
////					listReInsc.add(elem);
////					}
////					else 
////						{listInsc.add(elem);
////				        }
////			}
////		for(Student elem:listInsc) {
////			System.out.println(elem);
////		}
////		return listInsc;
////	}

}
