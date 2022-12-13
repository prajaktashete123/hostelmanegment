package com.boot.service;

import java.util.List;


import com.boot.payload.HostelDTO;

public interface HostelService {
	
	
	public HostelDTO addHostel(HostelDTO hostel);
     
	public List<HostelDTO> getAllHostelList();
	
	public HostelDTO getHostelById(int hostelId);
	
	public void deleteHostelById(int hostelId);
		
	public HostelDTO updateHostelById(HostelDTO hostel,int hostelId);
		

}
