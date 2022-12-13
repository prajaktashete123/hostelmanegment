package com.boot.serviceImplimentation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.CollegeEntity;
import com.boot.exception.ResourceNotFoundException;
import com.boot.payload.CollegeDTO;
import com.boot.repository.CollegeRepository;
import com.boot.service.CollegeService;

@Service
public class CollegeServiceImplimentation implements CollegeService

{
	
	@Autowired
	private CollegeRepository collegeRepository;
     @Autowired
     private ModelMapper modelMapper;

	@Override
	public CollegeDTO addCollege(CollegeDTO college) {

		
		   CollegeEntity collegeEntity =this.modelMapper.map(college,CollegeEntity.class);
			CollegeEntity savedCollegeEntity=this.collegeRepository.save(collegeEntity);
			return this.modelMapper.map(savedCollegeEntity,CollegeDTO.class);
			
			
		}
	

	@Override
	public List<CollegeDTO> getAllCollegeList() {
		
			List<CollegeEntity> collegeList =this.collegeRepository.findAll();
			List<CollegeDTO>  collegeListDto = collegeList.stream().map(college->this.modelMapper.map(college, CollegeDTO.class)).collect(Collectors.toList());

			return collegeListDto;
			//return null;
		}
	

	@Override
	public CollegeDTO getCollegeById(int collegeId) {
		
			CollegeEntity collegeObj=this.collegeRepository.
		                     findById(collegeId).orElseThrow(()-> new ResourceNotFoundException("college","collegeID", collegeId));	          
		           
		     return this.modelMapper.map(collegeObj,CollegeDTO.class);
			//return null;
		}
	

	@Override
	public void deleteCollegeById(int collegeId) {
		if(this.collegeRepository.existsById(collegeId))
		{
			this.collegeRepository.deleteById(collegeId);
		}
		else
		{
			throw new ResourceNotFoundException("college","collegeID", collegeId);	
		}
	
		
	}

@Override
	public CollegeDTO updateCollegeById(CollegeDTO college, int collegeId) {
	if(this.collegeRepository.existsById(collegeId))
    {
    	CollegeEntity collegeObj= this.modelMapper.map(college, CollegeEntity.class);
    	CollegeEntity updatedCollege=this.collegeRepository.save(collegeObj);
    	
    	return this.modelMapper.map(updatedCollege, CollegeDTO.class);
    	}
    else
    {
    	throw new ResourceNotFoundException("College","CollegeID",collegeId);
    }
	
}
	}


