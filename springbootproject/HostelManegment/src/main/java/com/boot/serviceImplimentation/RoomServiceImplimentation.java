package com.boot.serviceImplimentation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.HostelEntity;
import com.boot.entity.RoomEntity;
import com.boot.entity.StudentEntity;
import com.boot.exception.ResourceNotFoundException;
import com.boot.payload.HostelDTO;
import com.boot.payload.RoomDTO;
import com.boot.payload.StudentDTO;
import com.boot.repository.RoomRepository;
import com.boot.service.RoomService;

@Service
public class RoomServiceImplimentation implements RoomService {
	
	@Autowired
	private RoomRepository roomRepository;
     @Autowired
     private ModelMapper modelMapper;

	@Override
	public RoomDTO addRoom(RoomDTO Room) {
		RoomEntity roomEntity =this.modelMapper.map(Room,RoomEntity.class);
		RoomEntity savedRoomEntity=this.roomRepository.save(roomEntity);
		return this.modelMapper.map(savedRoomEntity,RoomDTO.class);
		
	}

	@Override
	public List<RoomDTO> getAllRoomList() {
		List<RoomEntity> roomList =this.roomRepository.findAll();
		List<RoomDTO>  roomListDto = roomList.stream().map(room->this.modelMapper.map(room,RoomDTO.class)).collect(Collectors.toList());

		return roomListDto;
	}

	@Override
	public RoomDTO getRoomById(int roomId) {
		RoomEntity roomObj=this.roomRepository.
                findById(roomId).orElseThrow(()-> new ResourceNotFoundException("room","roomID", roomId));	          
      
return this.modelMapper.map(roomObj,RoomDTO.class);
	}

	@Override
	public void deleteRoomById(int roomId) {
		if(this.roomRepository.existsById(roomId))
		{
			this.roomRepository.deleteById(roomId);
		}
		else
		{
			throw new ResourceNotFoundException("room","roomID", roomId);	
		}
		
	}

	@Override
	public RoomDTO updateRoomById(RoomDTO room, int roomId) {
		if(this.roomRepository.existsById(roomId)) 
		{
			RoomEntity roomObj = this.modelMapper.map(room,RoomEntity.class);
			RoomEntity updatedRoom= this.roomRepository.save(roomObj);
			
			return this.modelMapper.map(updatedRoom, RoomDTO.class);
		}
		else
		{
			throw new ResourceNotFoundException("Room","RoomId", roomId);
		}
	}

	@Override
	public List<RoomDTO> getAllRoomsByHostelId(int hostelId) {
		
		List<RoomEntity>  getAllRoomByHostelId = this.roomRepository.getAllRoomsByHostelId(hostelId);
		
		List<RoomDTO>  roomListDto = getAllRoomByHostelId.stream().map(room->this.modelMapper.map(room,RoomDTO.class)).collect(Collectors.toList());

		
		return roomListDto;
		
		
		
	}

}
