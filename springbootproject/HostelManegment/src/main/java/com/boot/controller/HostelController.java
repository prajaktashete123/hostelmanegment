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
import com.boot.payload.HostelDTO;
import com.boot.service.HostelService;



@RestController
@RequestMapping("/hostel")
@CrossOrigin("*")
public class HostelController {
	@Autowired
	private HostelService hostelService;
	
	@PostMapping// end point to add new record
	@RequestMapping(value="/",method=RequestMethod.POST)//end point or mapping method
	
	public ResponseEntity<HostelDTO> addHostel(@Valid @RequestBody HostelDTO hostel)
	{
		//ResponseEntity
	
		HostelDTO addHostel = this.hostelService.addHostel(hostel);
		
		
   
		return new ResponseEntity<HostelDTO>(addHostel,HttpStatus.CREATED);
		
		
	}
	
	@GetMapping("/")//end point to featch all student record
	public ResponseEntity<List<HostelDTO>> getAllHostel()
	{
		List<HostelDTO> allhostelList = this.hostelService.getAllHostelList();
		return new ResponseEntity<List<HostelDTO>>(allhostelList,HttpStatus.OK);
		
   }
   
	@GetMapping("/{hostelId}")
	public ResponseEntity<HostelDTO> getHostel(@PathVariable("hostelId") int hostelId)
	{
		HostelDTO hostelObj = this.hostelService.getHostelById(hostelId);
		return new ResponseEntity<HostelDTO>(hostelObj,HttpStatus.OK);
	}
	
	@PutMapping("/{hostelId}")
	
	public ResponseEntity<HostelDTO> updateHostelById(@Valid @RequestBody HostelDTO hostel,@PathVariable("hostelId") int hostelId)
	{
		HostelDTO updatedhostel = this.hostelService.updateHostelById(hostel, hostelId);
		return new ResponseEntity<HostelDTO>(updatedhostel,HttpStatus.OK);
	}
	
	@DeleteMapping("/{hostelId}")
	public ResponseEntity<ApiResponse> deleteHostel(@PathVariable("hostelId")int hostelId)
	{
		this.hostelService.deleteHostelById(hostelId);
		
		ApiResponse response=new ApiResponse();
		
		response.setMessage("hostel record is deleted with hostel Id: "+hostelId);
		
		response.setStatus(true);
		
	    return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
	    			
	}

	
	
	
	
}
	