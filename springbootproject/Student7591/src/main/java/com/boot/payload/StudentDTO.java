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
@NoArgsConstructor
@ToString

public class StudentDTO {

	private int studentId;
	 
	private String studentName;
	
	private String studentEmail;
	
	private int studentAge;
	
	private String studentPassword;
	
	private String studentClass;
	
	@JsonIgnore
     private List<EnrolledCoursesEntity> studentList=new ArrayList<>();

	

	
}
