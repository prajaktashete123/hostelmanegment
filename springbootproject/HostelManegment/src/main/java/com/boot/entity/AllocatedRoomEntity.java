package com.boot.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class AllocatedRoomEntity {
	
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	  private int allocatedRoomId;
	 
	 @NotNull
	 private int hostelId;
	 
	 @NotNull
	 private int floorId;
	 
	 
	
	
	
	 
	 @ManyToOne
     @JoinColumn(name="rid")
     private RoomEntity room;
	 
	 
	
	 @OneToOne
	 @JoinColumn(name="sid")
	 private StudentEntity studentEntity;
	 
	
	
	
	
	
	
	

}
