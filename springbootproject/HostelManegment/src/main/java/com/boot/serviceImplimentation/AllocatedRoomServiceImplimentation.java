package com.boot.serviceImplimentation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.AllocatedRoomEntity;
import com.boot.entity.CollegeEntity;
import com.boot.entity.RoomEntity;
import com.boot.exception.ResourceNotFoundException;
import com.boot.payload.AllocatedRoomDTO;
import com.boot.payload.CollegeDTO;
import com.boot.repository.AllocatedRoomRepository;
import com.boot.repository.RoomRepository;
import com.boot.service.AllocatedRoomService;

@Service
public class AllocatedRoomServiceImplimentation implements AllocatedRoomService {
     
	@Autowired
	private AllocatedRoomRepository allocatedroomRepository;
     @Autowired
     private ModelMapper modelMapper;
     
     @Autowired
     private RoomRepository roomRepository;
	
	
	
	@Override
	public AllocatedRoomDTO addAllocatedRoom(AllocatedRoomDTO allocatedroom) {
		AllocatedRoomEntity allocatedroomEntity =this.modelMapper.map(allocatedroom,AllocatedRoomEntity.class);
		AllocatedRoomEntity savedAllocatedRoomEntity=this.allocatedroomRepository.save(allocatedroomEntity);
		
	
		int roomId = allocatedroom.getRoom().getRoomId();
		
		RoomEntity roomObj = this.roomRepository.findById(roomId).get();
		int capacity = roomObj.getRoomCapacity();
			
		if(capacity>0)
		{
			capacity= capacity-1;
			roomObj.setRoomCapacity(capacity);
			this.roomRepository.save(roomObj);
					
			
		}
		return this.modelMapper.map(savedAllocatedRoomEntity,AllocatedRoomDTO.class);
		
	}

	@Override
	public List<AllocatedRoomDTO> getAllAllocatedRoomList() {
		List<AllocatedRoomEntity> allocatedroomList =this.allocatedroomRepository.findAll();
		List<AllocatedRoomDTO>  allocatedroomListDto = allocatedroomList.stream().map(allocatedroom->this.modelMapper.map(allocatedroom, AllocatedRoomDTO.class)).collect(Collectors.toList());

		return allocatedroomListDto;
	}

	@Override
	public AllocatedRoomDTO getAllocatedRoomById(int allocatedroomId) {
		AllocatedRoomEntity allocatedroomObj=this.allocatedroomRepository.
                findById(allocatedroomId).orElseThrow(()-> new ResourceNotFoundException("allocatedroom","allocatedroomID", allocatedroomId));	          
      
       return this.modelMapper.map(allocatedroomObj,AllocatedRoomDTO.class);
	}

	@Override
	public void deleteAllocatedRoomById(int allocatedroomId) {
		if(this.allocatedroomRepository.existsById(allocatedroomId))
		{
			this.allocatedroomRepository.deleteById(allocatedroomId);
		}
		else
		{
			throw new ResourceNotFoundException("allocatedroom","allocatedroomID", allocatedroomId);	
		}
	
		
	}

	@Override
	public AllocatedRoomDTO updateAllocatedRoomById(AllocatedRoomDTO allocatedroom, int allocatedroomId) {
		if(this.allocatedroomRepository.existsById(allocatedroomId))
	    {
			AllocatedRoomEntity allocatedroomObj= this.modelMapper.map(allocatedroom, AllocatedRoomEntity.class);
			AllocatedRoomEntity updatedAllocatedRoom=this.allocatedroomRepository.save(allocatedroomObj);
	    	
	    	return this.modelMapper.map(updatedAllocatedRoom, AllocatedRoomDTO.class);
	    	}
	    else
	    {
	    	throw new ResourceNotFoundException("AllocatedRoom","AllocatedRoomID",allocatedroomId);
	    }
	}
	
	
	
	

}
