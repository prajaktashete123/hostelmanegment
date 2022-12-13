package com.boot.payload;





//import com.boot.entity.StudentEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AllocatedRoomDTO {
	
	
	private int allocatedroomId;
	
	
	
	 private int hostelId;
	
	 private int floorId;
	 
	
	 
	// @JsonIgnore
	 private RoomDTO room;
	 
	 
	// @JsonIgnore
	 private StudentDTO studentEntity;

}
