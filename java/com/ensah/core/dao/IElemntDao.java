package com.ensah.core.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ensah.core.bo.Element;


public interface IElemntDao extends JpaRepository<Element, Long>   {


		
		public List<Element> findElementsByModule(com.ensah.core.bo.Module ml);
		
		
	

}
