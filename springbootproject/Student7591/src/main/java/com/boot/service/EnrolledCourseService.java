package com.boot.service;


	import java.util.List;

	import com.boot.payload.EnrolledCourseDTO;

	public interface EnrolledCourseService 
	{
		 public EnrolledCourseDTO addCourse(EnrolledCourseDTO enrolledcourse);
			
			public List<EnrolledCourseDTO> getAllEnrolledCourse();
			
			public  EnrolledCourseDTO getEnrolledCourseById(int enrolledId);
		
			public  List<EnrolledCourseDTO> getEnrolledCourseByStudentId(int studentId);
			
			public List<EnrolledCourseDTO> getEnrolledCourseByCoursetId(int courseId);

}
