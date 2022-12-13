package com.boot.payload;



import java.util.ArrayList;
import java.util.List;

import com.boot.entity.FloorEntity;
import com.boot.entity.HostelEntity;
import com.boot.entity.WardenEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

//import java.util.ArrayList;
//import java.util.List;


//import com.boot.entity.WardenEntity;
//import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class WardenDTO {
	
	
	
	private int wardenId;
	
	private String wardenName;
	
	private String wardenEmail;
	 
	private String wardenMobile;
	
	
	
	//@JsonIgnore
	 private HostelDTO hostel;
	
	 
	 @JsonIgnore
	 private List<FloorDTO> floorList1=new ArrayList<>();
	 
	   
}
