package com.ensah.core.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.ensah.core.bo.Module;
import com.ensah.core.bo.Niveau;
@Service
public interface ImoduleDao extends JpaRepository<Module, Long> {
	
    //@Query("From module where idNiveau=:n")
	//public List<Module> findModuleByNiveau(@Param("n")long idniveau);
	

	public List<Module> findAllByNiveau(Niveau niveau);

 

}
