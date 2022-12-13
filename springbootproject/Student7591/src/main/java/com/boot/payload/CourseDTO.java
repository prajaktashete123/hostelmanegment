package com.boot.payload;


import java.util.ArrayList;
import java.util.List;

import com.boot.entity.EnrolledCoursesEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor

public class CourseDTO {
   
	private int courseId;
	
	
	private String courseName;
	
	
	private String courseDiscription;
	
	
	private String courseDuration;
	
	
	private int courseFee;
	
	 
    @JsonIgnore
    private List<EnrolledCoursesEntity> courseList=new ArrayList<>();
	

}
