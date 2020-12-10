package com.cg.vms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.vms.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
