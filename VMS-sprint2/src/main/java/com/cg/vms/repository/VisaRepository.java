package com.cg.vms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.vms.model.Visa;

@Repository
public interface VisaRepository  extends JpaRepository <Visa,Integer>{ //jparepository directly implements the data
	

}
