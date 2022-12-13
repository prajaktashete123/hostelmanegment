package com.boot.service;

import java.util.List;


import com.boot.payload.WardenDTO;

public interface WardenService {
	
	
public WardenDTO addWarden(WardenDTO warden);
    
	public List<WardenDTO> getAllWardenList();
	
	public WardenDTO getWardenById(int wardenId);
	
	public void deleteWardenById(int wardenId);
		
	public WardenDTO updateWardenById(WardenDTO warden,int wardenId);
		

}
