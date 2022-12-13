package com.boot.entity;






import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
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
@Table(name="student_t")
public class StudentEntity {
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int studentId;
	
	

	@NotEmpty( message="student name can not be empty")
    @Column(nullable=false)
    @Size(min=2,max=10,message="student name must be minimum 2 characters and maximum 10")
	private String  studentName;
	
	 @Email(message ="Email is not valid")
     @NotEmpty(message ="Email can not be empty")
     @Column(nullable=false)
	 private String studentEmail;
	 
//	 @Column(nullable=false)
//	 @NotNull(message="Student password can not be empty")
//	 @Size(min=2,max=10,message="Student class must be minimum 2 characters and maximum 10")
//	 private String studentPassword;
//	
	 

	 @NotEmpty( message="course name can not be empty")
     @Column(nullable=false)
    @Size(min=2,max=10,message="course name must be minimum 2 characters and maximum 10") 
	 private String courseName;
	
	 
	 @NotEmpty(message="mobile no can not be empty")
	 @Column(nullable=false)
	 @Size(min=1,max=10,message="mobile no must be 10 digit")
	 private String studentMobile;
	 
	 
	 @ManyToOne
     @JoinColumn(name="hid")
     private HostelEntity hostel;
	 
	// @NotEmpty(message="hostelAvailed can not be empty")
	 private boolean isHostelAvailed=false;
	 
	 
	 
	
	 
	 
	 
	 
//	 @OneToOne(mappedBy = "studentEntity")
	
//	 @JsonIgnore
//	 private  AllocatedRoomEntity allocatedRoom;
//	 

	
	 

}
