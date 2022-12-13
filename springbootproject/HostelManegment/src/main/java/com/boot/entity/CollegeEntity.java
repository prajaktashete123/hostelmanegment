package com.boot.entity;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;import org.hibernate.boot.jaxb.mapping.spi.JaxbCascadeType;

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
@Table(name="college_t")

public class CollegeEntity {
	
	
	 @Id
 	@GeneratedValue(strategy=GenerationType.AUTO)
	private int collegeId;
	
	
	
	
	 @NotEmpty( message="college name can not be empty")
     @Column(nullable=false)
     @Size(min=2,max=10,message="college name must be minimum 2 characters and maximum 20")
	 private String collegeName;
	 
	 
	 @JsonIgnore
	 @OneToMany(mappedBy = "college", cascade = CascadeType.ALL)  
     private List<HostelEntity> hostelList=new ArrayList<>();
	 
	 
	 
	 
	 
	 

}
