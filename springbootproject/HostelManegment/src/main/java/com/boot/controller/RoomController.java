package com.boot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.exception.ApiResponse;
//import com.boot.payload.EnrolledCourseDTO;
//import com.boot.payload.HostelDTO;
import com.boot.payload.RoomDTO;
//import com.boot.service.HostelService;
import com.boot.service.RoomService;

@RestController
@RequestMapping("/room")
@CrossOrigin("*")
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
	@PostMapping// end point to add new record
	@RequestMapping(value="/",method=RequestMethod.POST)//end point or mapping method
	
	public ResponseEntity<RoomDTO> addRoom(@Valid @RequestBody RoomDTO room)
	{
		//ResponseEntity
	
		RoomDTO addRoom = this.roomService.addRoom(room);
		
		
   
		return new ResponseEntity<RoomDTO>(addRoom,HttpStatus.CREATED);
		
		
	}
	
	@GetMapping("/")//end point to featch all student record
	public ResponseEntity<List<RoomDTO>> getAllRoom()
	{
		List<RoomDTO> allroomList = this.roomService.getAllRoomList();
		return new ResponseEntity<List<RoomDTO>>(allroomList,HttpStatus.OK);
		
   }
   
	@GetMapping("/{roomId}")
	public ResponseEntity<RoomDTO> getRoom(@PathVariable("roomId") int roomId)
	{
		RoomDTO roomObj = this.roomService.getRoomById(roomId);
		return new ResponseEntity<RoomDTO>(roomObj,HttpStatus.OK);
	}
	
	@GetMapping("/hostel/{hostelId}")
	public ResponseEntity<List<RoomDTO>> getAllRoomsByHostelId(@PathVariable("hostelId") int hostelId)
	{
		List<RoomDTO> RoomList= this.roomService.getAllRoomsByHostelId(hostelId);
	   return new ResponseEntity<List<RoomDTO>>(RoomList,HttpStatus.OK);	
	}
	
	
	@PutMapping("/{roomId}")
	
	public ResponseEntity<RoomDTO> updateRoomById(@Valid @RequestBody RoomDTO room,@PathVariable("roomId") int roomId)
	{
		RoomDTO updatedroom = this.roomService.updateRoomById(room, roomId);
		return new ResponseEntity<RoomDTO>(updatedroom,HttpStatus.OK);
	}
	
	@DeleteMapping("/{roomId}")
	public ResponseEntity<ApiResponse> deleteRoomById(@PathVariable("roomId")int roomId)
	{
		this.roomService.deleteRoomById(roomId);
		
		ApiResponse response=new ApiResponse();
		
		response.setMessage("room record is deleted with room Id: "+roomId);
		
		response.setStatus(true);
		
	    return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
	    			
	}

	

}
