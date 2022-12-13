package com.boot.payload;

import java.util.ArrayList;
import java.util.List;

import com.boot.entity.FloorEntity;
import com.boot.entity.HostelEntity;
import com.boot.entity.StudentEntity;
import com.boot.entity.WardenEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class HostelDTO {
	
	
	 private int hostelId;
	 
	 private String hostelName;
	 
	 private String hostelFee;
	 
	 private String hostelType;
	 
		
	
	 @JsonIgnore
	 private List<WardenDTO> wardenList=new ArrayList<>();
	
	
	@JsonIgnore
	private List<StudentDTO> studentList=new ArrayList<>();
	
	
	  private CollegeDTO college;
	
	  @JsonIgnore
	   private List<FloorDTO> floorList=new ArrayList<>();
	 

}
