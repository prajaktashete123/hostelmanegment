package com.boot.entity;




import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name="hostel_t")
public class HostelEntity {
	
	
	@Id
	@GeneratedValue
	 private int hostelId;
	
	
	 @NotEmpty( message="hostel name can not be empty")
     @Column(nullable=false)
     @Size(min=2,max=10,message="hostel name must be minimum 2 characters and maximum 10")
	 private String hostelName;
	
	 
	 @Column(nullable=false)
     @NotNull(message="hostel fee can not be empty")
	 @Min(message="hostel fee should be mininum 2000", value=2000)
	 @Max(message="hostel fee should be maximum 10000", value=10000)
	 private String hostelFee;
	
	 
	 @NotEmpty(message="hostel type can not be empty")
	 @Column(nullable=false)
	 @Size(min=2,max=10,message="hostel type must be minimum 2 character and maximum 10")
	 private String hostelType;
	 
	 
	 @ManyToOne
     @JoinColumn(name="cid")
     private CollegeEntity college;
	 

	 
	 @JsonIgnore
	 @OneToMany(mappedBy= "hostel",cascade=CascadeType.ALL)
	 private List<StudentEntity> studentList=new ArrayList<>();
	 
	 @JsonIgnore
	 @OneToMany(mappedBy= "hostel",cascade=CascadeType.ALL)
	 private List<WardenEntity> wardenList=new ArrayList<>();
	 
	 
	 @JsonIgnore
	 @OneToMany(mappedBy= "hostel",cascade=CascadeType.ALL)
	 private List<FloorEntity> floorList=new ArrayList<>();
	 
	
	                 
	         

}
