package com.boot.service;

import java.util.List;

//import com.boot.entity.RoomEntity;
import com.boot.payload.RoomDTO;

public interface RoomService {
	
	public RoomDTO addRoom(RoomDTO Room);
    
	public List<RoomDTO> getAllRoomList();
	
	public RoomDTO getRoomById(int roomId);
	
	public void deleteRoomById(int roomId);
		
	public RoomDTO updateRoomById(RoomDTO room,int roomId);
	
	public List<RoomDTO>   getAllRoomsByHostelId(int hostelId);
		

}
