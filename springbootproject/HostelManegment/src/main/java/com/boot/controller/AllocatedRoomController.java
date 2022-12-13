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
import com.boot.payload.AllocatedRoomDTO;

import com.boot.service.AllocatedRoomService;


@RestController
@RequestMapping("/allocatedroom")
@CrossOrigin("*")
public class AllocatedRoomController {
	
	
	
	@Autowired
	private AllocatedRoomService allocatedroomService;
	
	@PostMapping// end point to add new record
	@RequestMapping(value="/",method=RequestMethod.POST)//end point or mapping method
	
	public ResponseEntity<AllocatedRoomDTO> addAllocatedRoomService(@Valid @RequestBody AllocatedRoomDTO allocatedroom)
	{
		//ResponseEntity
	
		AllocatedRoomDTO addAllocatedRoom = this.allocatedroomService.addAllocatedRoom(allocatedroom);
		
		
   
		return new ResponseEntity<AllocatedRoomDTO>(addAllocatedRoom,HttpStatus.CREATED);
		
		
	}
	
	@GetMapping("/")//end point to featch all student record
	public ResponseEntity<List<AllocatedRoomDTO>> getAllAllocatedRoom()
	{
		List<AllocatedRoomDTO> allallocatedroomList = this.allocatedroomService.getAllAllocatedRoomList();
		return new ResponseEntity<List<AllocatedRoomDTO>>(allallocatedroomList,HttpStatus.OK);
		
   }
   
	@GetMapping("/{allocatedroomId}")
	public ResponseEntity<AllocatedRoomDTO> getAllocatedRoom(@PathVariable("allocatedroomId") int allocatedroomId)
	{
		AllocatedRoomDTO allocatedroomObj = this.allocatedroomService.getAllocatedRoomById(allocatedroomId);
		return new ResponseEntity<AllocatedRoomDTO>(allocatedroomObj,HttpStatus.OK);
	}
	
	@PutMapping("/{allocatedroomId}")
	
	public ResponseEntity<AllocatedRoomDTO> updateAllocatedRoomById(@Valid @RequestBody AllocatedRoomDTO allocatedroom,@PathVariable("allocatedroomId") int allocatedroomId)
	{
		AllocatedRoomDTO updatedallocatedroom = this.allocatedroomService.updateAllocatedRoomById(allocatedroom, allocatedroomId);
		return new ResponseEntity<AllocatedRoomDTO>(updatedallocatedroom,HttpStatus.OK);
	}
	
	@DeleteMapping("/{allocatedroomId}")
	public ResponseEntity<ApiResponse> deleteAllocatedRoomById(@PathVariable("allocatedroomId")int allocatedroomId)
	{
		this.allocatedroomService.deleteAllocatedRoomById(allocatedroomId);
		
		ApiResponse response=new ApiResponse();
		
		response.setMessage("allocatedroom record is deleted with allocatedroom Id: "+allocatedroomId);
		
		response.setStatus(true);
		//return null;
	    return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
	    			
	}

}
