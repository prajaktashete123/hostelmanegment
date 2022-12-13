package com.boot.payload;





import java.util.ArrayList;
import java.util.List;

import com.boot.entity.HostelEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CollegeDTO {
	
	
	private int collegeId;
	
	private String collegeName;
	

	@JsonIgnore
	 private List<HostelDTO> hostelList=new ArrayList<>();
}
