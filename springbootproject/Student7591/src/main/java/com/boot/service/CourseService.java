package com.boot.service;

import java.util.List;


import com.boot.payload.CourseDTO;

public interface CourseService {
	
	public CourseDTO addCourse(CourseDTO course);
	
	public List<CourseDTO> getAllCoursesList();
	
	public CourseDTO getCourseById(int courseId);
	
	public CourseDTO updateCourseById(CourseDTO course,int courseId);
	
	public void deleteCourseById(int courseId);

	

	
	
	
	
}
