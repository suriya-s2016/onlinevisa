package com.cg.vms.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.vms.model.Eligibility;


@Repository
public interface EligibilityRepository extends JpaRepository <Eligibility,String>{
	
	
	

}
