package com.boot.serviceimplimentation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.EnrolledCoursesEntity;
//import com.boot.entity.StudentEntity;
import com.boot.exception.ResourceNotFoundException;
import com.boot.payload.EnrolledCourseDTO;
//import com.boot.payload.StudentDTO;
import com.boot.repository.CourseRepository;
import com.boot.repository.EnrolledCourseRepository;
import com.boot.repository.StudentRepository;
import com.boot.service.EnrolledCourseService;

@Service
public class EnrolledCourseServiceImplementation implements EnrolledCourseService
 {
	@Autowired
	private EnrolledCourseRepository enrolledCourseRepository;  
	
	@Autowired	
	private StudentRepository studentRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public EnrolledCourseDTO addCourse(EnrolledCourseDTO enrolledcourse)
	{
	 	EnrolledCoursesEntity enrolledCourseEntity= this.modelMapper.map(enrolledcourse, EnrolledCoursesEntity.class);
		EnrolledCoursesEntity savedEnrolledCourse =this.enrolledCourseRepository.save(enrolledCourseEntity);
	 	
		return this.modelMapper.map(savedEnrolledCourse, EnrolledCourseDTO.class);
}

	@Override
	public List<EnrolledCourseDTO> getAllEnrolledCourse() {
		
		List<EnrolledCoursesEntity> enrolledCoursesList = this.enrolledCourseRepository.findAll();
		List<EnrolledCourseDTO>  enrolledCoursesDTOList = enrolledCoursesList.stream().map(enrolledCourses->this.
				modelMapper.map(enrolledCourses, EnrolledCourseDTO.class))
				.collect(Collectors.toList());
		return enrolledCoursesDTOList;
	
	}

	@Override
	public EnrolledCourseDTO getEnrolledCourseById(int enrolledId) {
       
		
		if(this.enrolledCourseRepository.existsById(enrolledId)) 
		{
			EnrolledCoursesEntity enrolledCourseEntity = this.enrolledCourseRepository.findById(enrolledId).get();
			
			return this.modelMapper.map(enrolledCourseEntity, EnrolledCourseDTO.class);
		}
		else
		{
			throw new ResourceNotFoundException("enrolledCourses","EnrolledCourseId", enrolledId);
		}

	}

	@Override
	public List<EnrolledCourseDTO> getEnrolledCourseByStudentId(int studentId) 
	{

       
		  if(this.studentRepository.existsById(studentId))
		    {
		    	//StudentEntity updatedStudent=this.studentRepository.save(studentObj).get();
		    	List<EnrolledCoursesEntity> enrolledCoursesList =this.enrolledCourseRepository.getAllEnrolledCourseByStudentId(studentId);
		    	 
		    	List<EnrolledCourseDTO> enrolledCourseDTOList =enrolledCoursesList.stream()
		    	   .map(enrolledCourse ->this.modelMapper.map(enrolledCourse, EnrolledCourseDTO.class))
		    	   .collect(Collectors.toList());
		    	
		    	
		    	return enrolledCourseDTOList;
		    	
		    	
		    	}
		    else
		    {
		    	throw new ResourceNotFoundException("Student","StudentID",studentId);
		    }
		
		//return null;
	}

	@Override
	public List<EnrolledCourseDTO> getEnrolledCourseByCoursetId(int courseId) {
		
		
		if(this.courseRepository.existsById(courseId))
		{
		// TODO Auto-generated method stub
		List<EnrolledCoursesEntity> enrolledCoursesList =this.enrolledCourseRepository.getAllEnrolledCourseByCourseId(courseId);   	 
    	List<EnrolledCourseDTO> enrolledCourseDTOList =enrolledCoursesList.stream()
    	   .map(enrolledCourse ->this.modelMapper.map(enrolledCourse, EnrolledCourseDTO.class))
    	   .collect(Collectors.toList());
    	
    	
    	return enrolledCourseDTOList;
    	
    	
    	}
    else
    {
    	throw new ResourceNotFoundException("Course","CourseID",courseId);
    }
	}

}


	
	



