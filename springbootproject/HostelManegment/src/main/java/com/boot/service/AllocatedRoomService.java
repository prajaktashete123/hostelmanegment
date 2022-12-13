package com.boot.service;

import java.util.List;

import com.boot.payload.AllocatedRoomDTO;




public interface AllocatedRoomService {
	
	
	public AllocatedRoomDTO addAllocatedRoom(AllocatedRoomDTO allocatedroom);
	
	public List<AllocatedRoomDTO> getAllAllocatedRoomList();
	
   public AllocatedRoomDTO getAllocatedRoomById(int allocatedroomId);
	
	public void deleteAllocatedRoomById(int allocatedroomId);
		
	public AllocatedRoomDTO updateAllocatedRoomById(AllocatedRoomDTO allocatedroom,int allocatedroomId);

}
