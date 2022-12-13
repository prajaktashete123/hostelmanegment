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
import com.boot.payload.FloorDTO;

import com.boot.service.FloorService;


@RestController
@RequestMapping("/floor")
@CrossOrigin("*")
public class FloorController {
	@Autowired
	private FloorService floorService;
	
	@PostMapping// end point to add new record
	@RequestMapping(value="/",method=RequestMethod.POST)//end point or mapping method
	
	public ResponseEntity<FloorDTO> addFloor(@Valid @RequestBody FloorDTO floor)
	{
		//ResponseEntity
	
		FloorDTO addFloor = this.floorService.addFloor(floor);
		
		
   
		return new ResponseEntity<FloorDTO>(addFloor,HttpStatus.CREATED);
		
		
	}
	
	@GetMapping("/")//end point to featch all student record
	public ResponseEntity<List<FloorDTO>> getAllFloor()
	{
		List<FloorDTO> allfloorList = this.floorService.getAllFloorList();
		return new ResponseEntity<List<FloorDTO>>(allfloorList,HttpStatus.OK);
		
   }
   
	@GetMapping("/{floorId}")
	public ResponseEntity<FloorDTO> getFloorById(@PathVariable("floorId") int floorId)
	{
		FloorDTO floorObj = this.floorService.getFloorById(floorId);
		return new ResponseEntity<FloorDTO>(floorObj,HttpStatus.OK);
	}
	
	@PutMapping("/{floorId}")
	
	public ResponseEntity<FloorDTO> updateFloorById(@Valid @RequestBody FloorDTO floor,@PathVariable("floorId") int floorId)
	{
		FloorDTO updatedfloor = this.floorService.updateFloorById(floor, floorId);
		return new ResponseEntity<FloorDTO>(updatedfloor,HttpStatus.OK);
	}
	
	@DeleteMapping("/{floorId}")
	public ResponseEntity<ApiResponse> deleteFloorById(@PathVariable("floorId")int floorId)
	{
		this.floorService.deleteFloorById(floorId);
		
		ApiResponse response=new ApiResponse();
		
		response.setMessage("floor record is deleted with floor Id: "+floorId);
		
		response.setStatus(true);
		
	    return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
	    			
	}

	
	
	
	

}
