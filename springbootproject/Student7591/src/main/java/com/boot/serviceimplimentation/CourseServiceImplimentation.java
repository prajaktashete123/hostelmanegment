package com.boot.serviceimplimentation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.CourseEntity;

import com.boot.exception.ResourceNotFoundException;
import com.boot.payload.CourseDTO;

import com.boot.repository.CourseRepository;
import com.boot.service.CourseService;

@Service
public class CourseServiceImplimentation implements CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CourseDTO addCourse(CourseDTO course)
	
	{  CourseEntity courseEntity=this.modelMapper.map(course, CourseEntity.class);
	   CourseEntity savedCourse=this.courseRepository.save(courseEntity);
	   
	   return this.modelMapper.map(savedCourse,CourseDTO.class);
	   
		
		
	}

	@Override
	public List<CourseDTO> getAllCoursesList() {
		// TODO Auto-generated method stub
		List<CourseEntity> courseList =this.courseRepository.findAll();
		List<CourseDTO>  courseDTOList = courseList.stream().map(course->this.modelMapper.map(course,CourseDTO.class))
				.collect(Collectors.toList());
		return courseDTOList;
		
	}

	@Override
	public CourseDTO getCourseById(int courseId) {
		
		if(this.courseRepository.existsById(courseId)) {
			
			CourseEntity courseEntity=this.courseRepository.findById(courseId).get();
			return this.modelMapper.map(courseEntity,CourseDTO.class);
			
			
		}
		else
		{
			throw new ResourceNotFoundException("Course","CourseId",courseId);
			
		}
		
		
		
	}

	@Override
	public void  deleteCourseById(int courseId) {
		if(this.courseRepository.existsById( courseId)) {
			
			this.courseRepository.deleteById(courseId);
		}
		else
		{
			throw new ResourceNotFoundException("Course","CourseId", courseId);
		}
		
	}


@Override
	public CourseDTO updateCourseById(CourseDTO course, int courseId) {
		// TODO Auto-generated method stub
		 if(this.courseRepository.existsById(course.getCourseId()))
		   {
			   CourseEntity courseObj=this.modelMapper.map(course, CourseEntity.class);
			   CourseEntity updateCourse=this.courseRepository.save(courseObj);
			   
			   return this.modelMapper.map(updateCourse,CourseDTO.class);
			   
			    }
		   
		   else {
			   throw new ResourceNotFoundException("Course","courseID",course.getCourseId());
		   }
		
	}

}
