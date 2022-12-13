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
	//import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RestController;

	import com.boot.exception.ApiResponse;
	//import com.boot.exception.ResourceNotFoundException;
import com.boot.payload.CollegeDTO;

import com.boot.service.CollegeService;

	@RestController
	@RequestMapping("/college")
	@CrossOrigin("*")
	public class CollegeController 
	{
		@Autowired
		private CollegeService collegeService;
		
		@PostMapping// end point to add new record
		@RequestMapping(value="/",method=RequestMethod.POST)//end point or mapping method
		
		public ResponseEntity<CollegeDTO> addCollege(@Valid @RequestBody CollegeDTO college)
		{
			//ResponseEntity
		
			CollegeDTO addCollege = this.collegeService.addCollege(college);
			
			
	   
			return new ResponseEntity<CollegeDTO>(addCollege,HttpStatus.CREATED);
			
			
		}
		
		@GetMapping("/")//end point to featch all student record
		public ResponseEntity<List<CollegeDTO>> getAllCollege()
		{
			List<CollegeDTO> allcollegeList = this.collegeService.getAllCollegeList();
			return new ResponseEntity<List<CollegeDTO>>(allcollegeList,HttpStatus.OK);
			
	   }
	   
		@GetMapping("/{collegeId}")
		public ResponseEntity<CollegeDTO> getCollege(@PathVariable("collegeId") int collegeId)
		{
			CollegeDTO collegeObj = this.collegeService.getCollegeById(collegeId);
			return new ResponseEntity<CollegeDTO>(collegeObj,HttpStatus.OK);
		}
		
		@PutMapping("/{collegeId}")
		
		public ResponseEntity<CollegeDTO> updateCollegeById(@Valid @RequestBody CollegeDTO college,@PathVariable("collegeId") int collegeId)
		{
			CollegeDTO updatedcollege = this.collegeService.updateCollegeById(college, collegeId);
			return new ResponseEntity<CollegeDTO>(updatedcollege,HttpStatus.OK);
		}
		
		@DeleteMapping("/{collegeId}")
		public ResponseEntity<ApiResponse> deleteCollegeById(@PathVariable("collegeId")int collegeId)
		{
			this.collegeService.deleteCollegeById(collegeId);
			
			ApiResponse response=new ApiResponse();
			
			response.setMessage("college record is deleted with student Id: "+collegeId);
			
			response.setStatus(true);
			//return null;
		    return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
		    			
		}

}
