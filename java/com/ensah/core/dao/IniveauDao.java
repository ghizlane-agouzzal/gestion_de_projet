package com.ensah.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ensah.core.bo.Niveau;

public interface IniveauDao extends JpaRepository<Niveau, Long>{ 
}
