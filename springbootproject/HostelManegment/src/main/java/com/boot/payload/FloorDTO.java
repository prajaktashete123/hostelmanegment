package com.boot.payload;





import java.util.ArrayList;
import java.util.List;

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
public class FloorDTO {
	
	
	private int floorId; 
	
	 private int no_of_Room;
	 
	 private int no_of_floor;
	 
	 
	 
	//@JsonIgnore
	 private HostelDTO hostel;
	 
	
	 @JsonIgnore
	 private List<RoomDTO> roomList=new ArrayList<>();
	 
	 
	// @JsonIgnore
	 private WardenDTO warden;
		

}
