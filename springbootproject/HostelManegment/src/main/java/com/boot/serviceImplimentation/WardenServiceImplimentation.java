package com.boot.serviceImplimentation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.boot.entity.WardenEntity;
import com.boot.exception.ResourceNotFoundException;

import com.boot.payload.WardenDTO;

import com.boot.repository.WardenRepository;
import com.boot.service.WardenService;

@Service
public class WardenServiceImplimentation implements WardenService {
	
	
	@Autowired
	private WardenRepository wardenRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public WardenDTO addWarden(WardenDTO warden) {
       WardenEntity wardenEntity = this.modelMapper.map(warden, WardenEntity.class);
		
		WardenEntity savedWardenEntity = this.wardenRepository.save(wardenEntity);
		
		return this.modelMapper.map(savedWardenEntity, WardenDTO.class);
		
	}

	@Override
	public List<WardenDTO> getAllWardenList() {
		List<WardenEntity> wardenList =this.wardenRepository.findAll();
		List<WardenDTO>  wardenListDto = wardenList.stream().map(warden->this.modelMapper.map(warden, WardenDTO.class))
				.collect(Collectors.toList());
		return wardenListDto;
	}

	@Override
	public WardenDTO getWardenById(int wardenId) {
		WardenEntity wardenObj = this.wardenRepository
				.findById(wardenId).orElseThrow(()-> new ResourceNotFoundException("warden","wardenId",wardenId));
				return this.modelMapper.map(wardenObj, WardenDTO.class);
	}

	@Override
	public void deleteWardenById(int wardenId) {
		if(this.wardenRepository.existsById(wardenId)) 
		{
			this.wardenRepository.deleteById(wardenId);
			
		}
		else
		{
			throw new ResourceNotFoundException("Warden","WardenId", wardenId);
		}
		
	}

	@Override
	public WardenDTO updateWardenById(WardenDTO warden, int wardenId) {
		if(this.wardenRepository.existsById(wardenId)) 
		{
			WardenEntity wardenObj = this.modelMapper.map(warden,WardenEntity.class);
			WardenEntity updatedWarden= this.wardenRepository.save(wardenObj);
			
			return this.modelMapper.map(updatedWarden, WardenDTO.class);
		}
		else
		{
			throw new ResourceNotFoundException("Warden","WardenId", wardenId);
		}
	}

}
