package com.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.entity.CollegeEntity;
import com.boot.entity.StudentEntity;


public interface CollegeRepository extends JpaRepository<CollegeEntity,Integer> {
	
	

}