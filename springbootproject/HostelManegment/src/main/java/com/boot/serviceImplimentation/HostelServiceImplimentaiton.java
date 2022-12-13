package com.boot.serviceImplimentation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.boot.entity.HostelEntity;
import com.boot.exception.ResourceNotFoundException;

import com.boot.payload.HostelDTO;

import com.boot.repository.HostelRepository;
import com.boot.service.HostelService;
@Service
public class HostelServiceImplimentaiton implements HostelService



{
	
	@Autowired
	private HostelRepository hostelRepository;
     @Autowired
     private ModelMapper modelMapper;


	@Override
	public HostelDTO addHostel(HostelDTO hostel) {
		 HostelEntity hostelEntity =this.modelMapper.map(hostel,HostelEntity.class);
			HostelEntity savedHostelEntity=this.hostelRepository.save(hostelEntity);
			return this.modelMapper.map(savedHostelEntity,HostelDTO.class);
			
	}

	@Override
	public List<HostelDTO> getAllHostelList() {
		List<HostelEntity> hostelList =this.hostelRepository.findAll();
		List<HostelDTO>  hostelListDto = hostelList.stream().map(hostel->this.modelMapper.map(hostel,HostelDTO.class)).collect(Collectors.toList());

		return hostelListDto;
	}

	@Override
	public HostelDTO getHostelById(int hostelId) {
		HostelEntity hostelObj=this.hostelRepository.
                findById(hostelId).orElseThrow(()-> new ResourceNotFoundException("hostel","hostelID", hostelId));	          
      
return this.modelMapper.map(hostelObj,HostelDTO.class);
	}

	@Override
	public void deleteHostelById(int hostelId) {
		if(this.hostelRepository.existsById(hostelId))
		{
			this.hostelRepository.deleteById(hostelId);
		}
		else
		{
			throw new ResourceNotFoundException("hostel","hostelID", hostelId);	
		}
	
		
	}
		
	

	@Override
	public HostelDTO updateHostelById(HostelDTO hostel, int hostelId) {
		if(this.hostelRepository.existsById(hostelId))
	    {
	    	HostelEntity hostelObj= this.modelMapper.map(hostel, HostelEntity.class);
	    	HostelEntity updatedHostel=this.hostelRepository.save(hostelObj);
	    	
	    	return this.modelMapper.map(updatedHostel, HostelDTO.class);
	    	}
	    else
	    {
	    	throw new ResourceNotFoundException("Hostel","HostelID",hostelId);
	    }
		
	}
	}


