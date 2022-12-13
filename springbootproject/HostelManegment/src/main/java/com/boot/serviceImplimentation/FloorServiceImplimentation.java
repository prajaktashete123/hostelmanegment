package com.boot.serviceImplimentation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.CollegeEntity;
import com.boot.entity.FloorEntity;
import com.boot.entity.HostelEntity;
import com.boot.exception.ResourceNotFoundException;
import com.boot.payload.CollegeDTO;
import com.boot.payload.FloorDTO;
import com.boot.payload.HostelDTO;
import com.boot.repository.FloorRepository;
import com.boot.service.FloorService;



@Service
public class FloorServiceImplimentation implements FloorService {
	
	
	@Autowired
	private FloorRepository floorRepository;
     @Autowired
     private ModelMapper modelMapper;

	@Override
	public FloorDTO addFloor(FloorDTO floor) {
		FloorEntity floorEntity =this.modelMapper.map(floor,FloorEntity.class);
		FloorEntity savedFloorEntity=this.floorRepository.save(floorEntity);
		return this.modelMapper.map(savedFloorEntity,FloorDTO.class);
		
		
	}

	@Override
	public List<FloorDTO> getAllFloorList() {
		List<FloorEntity> floorList =this.floorRepository.findAll();
		List<FloorDTO>  floorListDto = floorList.stream().map(floor->this.modelMapper.map(floor,FloorDTO.class)).collect(Collectors.toList());

		return floorListDto;
	}

	@Override
	public FloorDTO getFloorById(int floorId) {
		FloorEntity floorObj=this.floorRepository.
                findById(floorId).orElseThrow(()-> new ResourceNotFoundException("floor","floorID", floorId));	          
      
return this.modelMapper.map(floorObj,FloorDTO.class);
	}

	@Override
	public void deleteFloorById(int floorId) {
		if(this.floorRepository.existsById(floorId))
		{
			this.floorRepository.deleteById(floorId);
		}
		else
		{
			throw new ResourceNotFoundException("floor","floorID", floorId);	
		}
	
	}

	@Override
	public FloorDTO updateFloorById(FloorDTO floor, int floorId) {
		if(this.floorRepository.existsById(floorId))
	    {
	    	FloorEntity floorObj= this.modelMapper.map(floor, FloorEntity.class);
	    	FloorEntity updatedFloor=this.floorRepository.save(floorObj);
	    	
	    	return this.modelMapper.map(updatedFloor, FloorDTO.class);
	    	}
	    else
	    {
	    	throw new ResourceNotFoundException("Floor","FloorID",floorId);
	    }
	}

}
