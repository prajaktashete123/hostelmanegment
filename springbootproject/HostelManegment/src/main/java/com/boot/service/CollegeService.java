package com.boot.service;

import java.util.List;

import com.boot.payload.CollegeDTO;

public interface CollegeService {
	
	public CollegeDTO addCollege(CollegeDTO student);
	
	public List<CollegeDTO> getAllCollegeList();
	
	public CollegeDTO getCollegeById(int collegeId);
	
	public void deleteCollegeById(int collegeId);
		
	public CollegeDTO updateCollegeById(CollegeDTO student,int studentId);
		

}
