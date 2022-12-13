package com.boot.service;

import java.util.List;

import com.boot.payload.FloorDTO;



public interface FloorService {

	
public FloorDTO addFloor(FloorDTO floor);
    
	public List<FloorDTO> getAllFloorList();
	
	public FloorDTO getFloorById(int floorId);
	
	public void deleteFloorById(int floorId);
		
	public FloorDTO updateFloorById(FloorDTO floor,int floorId);
		
	
	
}
