package com.cg.vms.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.vms.model.Client;




@Repository

public interface ClientRepository extends JpaRepository<Client, Long>{

}
