package com.ensah.core.utils;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.reactive.WebFluxProperties.Session;
import org.springframework.web.multipart.MultipartFile;

import com.ensah.core.bo.Etudiant;
import com.ensah.core.bo.Utilisateur;
import com.ensah.core.dao.IEtudiantDao;
import com.ensah.core.services.IEtudiantService;
import com.ensah.core.services.exceptions.ExcelHandlerException;
import com.ensah.core.services.impl.EtudiantServiceImpl;
import com.ensah.core.web.models.Student;
@MultipartConfig
//MA CLASSE DE L'IMPORTATION DE MON FICHIER EXCEEL EN VERIFIANT LE FORMAT ET DETECTANT LES PROBLEMES QUI PEUT ETRE SURVENUE EN LE STOCKANT LES INFPRMATIONS DANS UNE LISTE DES STUDENTS
public class ExcelImporter {
	@Autowired
	boolean errorOccured=false;
	private static String SHEET="feuille";
	static String[] HEADERS = {"ID ETUDIANT","CNE", "NOM", "PRENOM","ID NIVEAU ACTUEL","TYPE"};
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	public  static boolean hasExcelFormat(MultipartFile file){
        if(TYPE.equals(file.getContentType())){
            return  true;
        }
        return  false;
    }
	public List<Student>  ReadFileExcel(InputStream is,HttpSession session) {
		List<Student> List = new ArrayList<Student>();
	
	try {String mssg;
        Workbook workbook = new XSSFWorkbook(is);
        Sheet sheet = workbook.getSheet(SHEET);
        Iterator<Row> rows = sheet.iterator();
        int rowNmber=0;
        while(rows.hasNext()) {
        	Row currentRow = rows.next();

            Iterator<Cell> cellsInRow = currentRow.iterator();
            String []excelHeaders=new String[7];
            if(rowNmber==0){
            	rowNmber++;
                int i=0;
                while (cellsInRow.hasNext()){
                    Cell currentCell=cellsInRow.next();
                    excelHeaders[i]=currentCell.getStringCellValue();
                    System.out.println(currentCell.getStringCellValue());
                    i++;
                }

               
               if(i==6){//Si le nombre de colonnes est convenable
                   if(checkFileHeaders(HEADERS,excelHeaders)){//Si les entetes sont les memes
                   continue;
                   }
                   else {
                	   mssg="Entetes differentes";
                       System.out.println("Entetes differentes");
                       errorOccured=true;
                       session.setAttribute("message",mssg);
                       break;
                   }
               }
               else{
                   System.out.println("Le nombre de colonnes n'est pas convenable");
                   errorOccured=true;
                   mssg="Le nombre de colonnes n'est pas convenable";
                   session.setAttribute("message",mssg);
                   break;
               }

            }
        
        int cellX=0;
        long id=0,id_niveau=0;
        String nom="",prenom="",cne="",type="";
        Student etd=new Student(id,cne,nom,prenom,id_niveau,type);
        while (cellsInRow.hasNext()) {
            Cell currentCell=cellsInRow.next();
            switch (cellX){
            case 0:
                id=(long) currentCell.getNumericCellValue();
                etd.setId(id);
                break;
            case 1: cne=(String)currentCell.getStringCellValue();
            etd.setCNE(cne);
                break;
            case 2:nom=(String)currentCell.getStringCellValue();
            etd.setNom(nom);
                break;
            case 3:prenom =(String)currentCell.getStringCellValue();
            etd.setPrénom(prenom);
                break;
            case 4: id_niveau=(long)currentCell.getNumericCellValue();
            etd.setId_niveau_actuel(id_niveau);
                break;
            case 5:
                type=(String)currentCell.getStringCellValue();
                etd.setType(type);
                break;}
            cellX++;
        }
        System.out.println(nom+","+prenom+","+cne+","+id+","+id_niveau+","+type+"FIN");


        }
        
	}catch (Exception e) {
	
		
		System.out.println(e.getMessage());
		String mssg=e.getMessage();
		session.setAttribute("message",mssg);}
	return List;

	}
	
	
	public  boolean checkFileHeaders(String [] headers,String[] excelHeaders){
        boolean correct=true;
        for(int i=0;i<6;i++){
            if(!headers[i].equals(excelHeaders[i])){
                return  false;
            }
        }
        return  correct;
    }
//	public ArrayList<Student> InscEtudiant(MultipartFile is) throws IOException{
//		ExcelImporter tf=new ExcelImporter();
//		ArrayList<Student> listInsc=new ArrayList<Student>();
//		ArrayList<Student> listReInsc=new ArrayList<Student>();
//		EtudiantServiceImpl tt=new EtudiantServiceImpl();
//		List<Etudiant> ts=tt.getAllPerson();
//		List<Student> tr=tf.ReadFileExcel(is.getInputStream(),ses);
//		for(Student elem:tr) {
//			for(Etudiant ele:ts) {
//				if(elem.getCNE()==ele.getCne())
//					{listReInsc.add(elem);
//					}
//					else 
//						{listInsc.add(elem);
//				        }
//			}
//		}
//		return listInsc;
//		
//	}
//	
}
