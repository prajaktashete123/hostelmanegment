package com.boot.payload;





import java.util.ArrayList;

import java.util.List;

import com.boot.entity.AllocatedRoomEntity;
import com.boot.entity.HostelEntity;
import com.boot.entity.RoomEntity;
import com.boot.entity.StudentEntity;
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
	 
	private String courseName;
	
	private String studentMobile;
	
//	 private String studentPassword;

	//@JsonIgnore
	private HostelDTO hostel;
	
    private boolean isHostelAvailed=false;
	
	//private  AllocatedRoomDTO allocatedRoom;
	

}
