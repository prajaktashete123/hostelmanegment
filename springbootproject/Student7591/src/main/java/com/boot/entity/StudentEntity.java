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

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor

public class StudentEntity {
	
	     @Id
    	@GeneratedValue(strategy=GenerationType.AUTO)
	    private int studentId;
	      
	     @NotEmpty( message="Student name can not be empty")
	     @Column(nullable=false)
	     @Size(min=2,max=10,message="Student name must be minimum 2 characters and maximum 10")
	     
	     private String studentName;
	     
	     @Email(message ="Email is not valid")
	     @NotEmpty(message ="Email can not be empty")
	     @Column(nullable=false)
	     private String studentEmail;
	     
	     
	     @Column(nullable=false)
	     @NotNull(message="Student age can not be empty")
	     @Min(message="Minimum age of student should be 10",value=10)
	     @Max(message="Maximum age of student should be 25",value=25)
	    private int studentAge;
	     
	     @Column(nullable=false)
	     @NotNull(message="Student password can not be empty")
	     @Size(min=2,max=10,message="Student class must be minimum 2 characters and maximum 10")
		 private String studentPassword;
	     
	    @Column(nullable=false)
	    @NotEmpty(message="Student class can not be empty")
	    @Size(min=2,max=10,message="Student class must be minimum 2 characters and maximum 10")
	    private String studentClass;
	    
	   @JsonIgnore
	      @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)  
	      private List<EnrolledCoursesEntity> studentList=new ArrayList<>();
	
	
	
}
