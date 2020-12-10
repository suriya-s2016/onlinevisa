/**
 * 
 */
package com.cg.vms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.vms.model.CaseProcessing;

public interface ProcessingRepository extends JpaRepository<CaseProcessing, Integer> {

}
