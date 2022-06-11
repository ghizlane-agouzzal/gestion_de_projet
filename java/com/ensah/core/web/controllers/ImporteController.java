package com.ensah.core.web.controllers;

import java.io.IOException;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ensah.core.bo.*;
import com.ensah.core.bo.Module;
import com.ensah.core.dao.IElemntDao;
import com.ensah.core.dao.IEtudiantDao;
import com.ensah.core.dao.IIsncriptionDao;
import com.ensah.core.dao.IUtilisateurDao;
import com.ensah.core.dao.ImoduleDao;
import com.ensah.core.dao.InscriptionMatiereDao;
import com.ensah.core.services.ICompteService;
import com.ensah.core.services.IEtudiantService;
import com.ensah.core.services.INiveauService;
import com.ensah.core.services.IPersonService;
import com.ensah.core.services.InscriptionMatiereService;
import com.ensah.core.services.InscriptionModuleService;
import com.ensah.core.services.InscriptionService;
import com.ensah.core.services.exceptions.ExcelHandlerException;
import com.ensah.core.services.impl.EtudiantServiceImpl;
import com.ensah.core.services.impl.PersonServiceImpl;
import com.ensah.core.utils.ExcelImporter;
import com.ensah.core.web.models.AccountModel;
import com.ensah.core.web.models.PersonModel;
import com.ensah.core.web.models.Student;


@Controller

public class ImporteController {

	@Autowired
	private IUtilisateurDao personDao;
	@Autowired
	private IEtudiantDao StudentDao;

	@Autowired
	private ICompteService userService; // On obtient par injection automatique le service

	@Autowired
	private IPersonService personService; // On obtient par injection automatique le service
	
	
	@Autowired 
	private InscriptionService IN;
	
	@Autowired 
	private IEtudiantService Et;
	@Autowired
	InscriptionMatiereService IM;
	@Autowired
	ImoduleDao Imo;
	@Autowired
	INiveauService Niv;
	@Autowired
	IIsncriptionDao InscD;
	@Autowired
	InscriptionModuleService inscM;
	@Autowired
	InscriptionMatiereDao im;
	@Autowired
	IElemntDao ele;
	
	@PostMapping(value="/admin/importExcelFile")
	@ResponseBody
	public String importFromExcel(@RequestParam("file") MultipartFile file,HttpSession session ,Model model) throws IOException, ExcelHandlerException {
		List<Student> td= new ArrayList<Student>();
		ExcelImporter excelImporter=new ExcelImporter();
		td=excelImporter.ReadFileExcel(file.getInputStream(), session);
		for(Student t: td) {
			System.out.println(t);
		}
		Module M = new Module();
	
		List<Module> Mod = new ArrayList<Module>();
		InscriptionAnnuelle I = new InscriptionAnnuelle();
		List<Element> el = new ArrayList<Element>();
		List<InscriptionAnnuelle> I2= new ArrayList<InscriptionAnnuelle>();
		Niveau Ni = new Niveau();
		model.addAttribute("listStudent", td);
	    List<Etudiant>Etd=Et.getAllEtudiants();
	    model.addAttribute("users",Etd);
		for(Etudiant e:Etd) {
			System.out.println(e);
		}
//		for(Student S : td) {
//			
//			int Nu=Math.toIntExact(S.getId());
//			Ni =Niv.getNIveauById(Nu);
//			long id=S.getId();
//			String type=S.getType();
//			String nom=S.getNom();
//			String prenom=S.getPrénom();
//			String cne = S.getCNE();
//			Etudiant E = new Etudiant ();
//			
//			if(!(Etd.contains(S.getId()))) {
//				
//				
//				
//				//on va faire un enregistrement au niveau de l'inscription
//				InscriptionAnnuelle I3= new InscriptionAnnuelle();
//				I3.setType(type);
//				E.setCne(cne);
//				Et.addEtudiant(E);
//				E=Et.getEtudiantByCne(cne);
//				I3.setNiveau(Ni);
//				I3.setEtudiant(E);
//				IN.addInscription(I3);
//				
//				I2=InscD.findAllByEtudiant(E);
//				I3=I2.get(I2.size()-1);
//				
//				//Inscription Module
//				Mod = Imo.findAllByNiveau(Ni);
//				for(Module ml : Mod) {
//					
//					InscriptionModule ms = new InscriptionModule();
//					
//					ms.setInscriptionAnnuelle(I3);
//					ms.setModule(ml);
//					
//					inscM.addInscModule(ms);
//					
//					
//					
//				}
//				
//				
//				//Inscription matiere 
//				
//				for(Module ml : Mod) {
//					el=ele.findElementsByModule(ml);
//					for(Element  o : el) {
//						InscriptionMatiere m = new InscriptionMatiere();
//						m.setInscriptionAnnuelle(I3);
//						m.setMatiere(o);
//						IM.addMatiere(m);
//					}
//				}
//	
//				
//			}else  {
//				
//				
//				E.setCne(cne);
//				E.getIdUtilisateur();
//				I2=InscD.findAllByEtudiant(E);
//				I=I2.get((I2.size())-1);
//				if(I.getValidation()=="V") {
//				Mod =Imo.findAllByNiveau(Ni); 
//				for(Module Ml : Mod ) {
//					
//					
//				InscriptionModule Ms = new InscriptionModule();
//					
//					Ms.setModule(Ml);
//					Ms.setInscriptionAnnuelle(I);
//					
//					inscM.addInscModule(Ms);
//					
//				}
//				
//				
//				// on effectue maintenant une inscription au niveau des de matière
//				for(Module ml : Mod) {
//					el=ele.findElementsByModule(ml);
//					
//						
//						for(Element o : el) {
//							
//							InscriptionMatiere m = new InscriptionMatiere();
//							
//							m.setInscriptionAnnuelle(I);
//							m.setMatiere(o);
//							
//							IM.addMatiere(m);
//						
//						
//					}
	
				
			//}
			
	
			
		//}
	//		}

			
//}
		
		if(session!=null) 
			return "/admin/error";
		else
		return "/admin/importExcelFile";	
}
}