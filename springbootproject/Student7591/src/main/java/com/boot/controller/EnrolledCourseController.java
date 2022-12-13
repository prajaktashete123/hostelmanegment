package com.boot.controller;


	import java.util.List;


	import javax.validation.Valid;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	import com.boot.payload.EnrolledCourseDTO;
	import com.boot.service.EnrolledCourseService;

	@RestController
	@RequestMapping("/enrolledCourse")
	public class EnrolledCourseController
	{     
		@Autowired
		 private EnrolledCourseService enrolledCourseService;
		
		@PostMapping("/addCourse")
		public ResponseEntity<EnrolledCourseDTO> enrolledCourse(@Valid @RequestBody EnrolledCourseDTO enroledCourseDTO)
		{
			EnrolledCourseDTO enrolledCourse =this.enrolledCourseService.addCourse(enroledCourseDTO);
		    return new ResponseEntity<EnrolledCourseDTO>(enroledCourseDTO,HttpStatus.CREATED);
		}
	  
		
		@GetMapping("/")
		public ResponseEntity<List<EnrolledCourseDTO>> getAllEnrolledCourses()
		{
			
			List<EnrolledCourseDTO> enrolledcourseList = this.enrolledCourseService.getAllEnrolledCourse();
			return new ResponseEntity<List<EnrolledCourseDTO>>(enrolledcourseList,HttpStatus.OK);
			
	   }
		
		@GetMapping("/{enrolledId}")
		public ResponseEntity<EnrolledCourseDTO> getEnrolledCourseById(@PathVariable("enrolledId") int enrolledId)
		{
			EnrolledCourseDTO  enrolledcourse = this.enrolledCourseService.getEnrolledCourseById(enrolledId);
			return new ResponseEntity<EnrolledCourseDTO>(enrolledcourse,HttpStatus.OK);
		}
	   
		
		@GetMapping("/student/{studentId}")
		public ResponseEntity<List<EnrolledCourseDTO>>getAllEnrolledCoursesByStudentId(@PathVariable("studentId") int studentId)
		{
			List<EnrolledCourseDTO> enrolledCourseList= this.enrolledCourseService.getEnrolledCourseByStudentId(studentId);
		   return new ResponseEntity<List<EnrolledCourseDTO>>(enrolledCourseList,HttpStatus.OK);	
		}


		@GetMapping("/course/{courseId}")
		public ResponseEntity<List<EnrolledCourseDTO>>getAllEnrolledCoursesBycourseId(@PathVariable("courseId") int courseId)
		{
			List<EnrolledCourseDTO> enrolledCourseList= this.enrolledCourseService.getEnrolledCourseByCoursetId(courseId);
		   return new ResponseEntity<List<EnrolledCourseDTO>>(enrolledCourseList,HttpStatus.OK);	
		}

	

}
