package com.boot.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//import javax.validation.constraints.Max;
//import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Table(name="course")
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CourseEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int courseId;
	
	@Column(unique=true)
	@NotEmpty(message="course name not be empty")
	@Size(min=4,max=10,message="course name must be minimum 4 character and maximum 10")
	private String courseName;
	
	@Column(nullable=false)
	@NotEmpty(message="course discription name not be empty")
	@Size(min=2,max=10,message="course discription  must be minimum 4 character and maximum 10")
	private String courseDiscription;
	
	@Column(nullable=false)
	@NotEmpty(message="course duration can not be empty")
	@Size(min=2,max=10,message="Course  Duration must be minimum 4 character and maximum 10")
	private String courseDuration;
	
	@Column(nullable=false)
	@NotNull(message="course fee can not be empty")
	//@Min(message="minimum course fee of student fee should be 500",value=500)
	//@Max(message="maximum course fee of student should be 1000",value=1000)
	private int courseFee;
	
	 @JsonIgnore
     @OneToMany(mappedBy ="course1" ,cascade = CascadeType.ALL)
     private List<EnrolledCoursesEntity> courseList=new ArrayList<>();

}
