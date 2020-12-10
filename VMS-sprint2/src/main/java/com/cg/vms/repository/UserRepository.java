package com.cg.vms.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.vms.model.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
}
