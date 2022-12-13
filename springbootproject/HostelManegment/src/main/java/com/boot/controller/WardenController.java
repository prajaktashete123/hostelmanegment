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
import com.boot.payload.WardenDTO;
import com.boot.service.WardenService;


	
	
	@RestController
	@RequestMapping("/warden")
	@CrossOrigin("*")
	public class WardenController {
	
		@Autowired
		private WardenService wardenService;
		
		@PostMapping// end point to add new record
		@RequestMapping(value="/",method=RequestMethod.POST)//end point or mapping method
		
		public ResponseEntity<WardenDTO> addWarden(@Valid @RequestBody WardenDTO warden)
		{
			//ResponseEntity
		
			WardenDTO addWarden = this.wardenService.addWarden(warden);
			
			
	   
			return new ResponseEntity<WardenDTO>(addWarden,HttpStatus.CREATED);
			
			
		}
		
		@GetMapping("/")//end point to featch all student record
		public ResponseEntity<List<WardenDTO>> getAllWarden()
		{
			List<WardenDTO> allWardenList = this.wardenService.getAllWardenList();
			return new ResponseEntity<List<WardenDTO>>(allWardenList,HttpStatus.OK);
			
	   }
	   
		@GetMapping("/{wardenId}")
		public ResponseEntity<WardenDTO> getWardenById(@PathVariable("wardenId") int wardenId)
		{
			WardenDTO wardenObj = this.wardenService.getWardenById(wardenId);
			return new ResponseEntity<WardenDTO>(wardenObj,HttpStatus.OK);
		}
		
		@PutMapping("/{wardenId}")
		
		public ResponseEntity<WardenDTO> updateWardenById(@Valid @RequestBody WardenDTO warden,@PathVariable("wardenId") int wardenId)
		{
			WardenDTO updatedwarden = this.wardenService.updateWardenById(warden, wardenId);
			return new ResponseEntity<WardenDTO>(updatedwarden,HttpStatus.OK);
		}
		
		@DeleteMapping("/{wardenId}")
		public ResponseEntity<ApiResponse> deleteWardenById(@PathVariable("wardenId")int wardenId)
		{
			this.wardenService.deleteWardenById(wardenId);
			
			ApiResponse response=new ApiResponse();
			
			response.setMessage("warden record is deleted with warden Id: "+wardenId);
			
			response.setStatus(true);
			
		    return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
		    			
		}

		
		
		

}
