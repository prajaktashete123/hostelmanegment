package com.boot.entity;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;

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
@Table(name="floor_t")
public class FloorEntity {
	
	 @Id
	 @GeneratedValue
	 private int floorId;
	
	 @NotNull(message=" no_of_room can not be empty")
	 @Column(nullable=false)
	 private int no_of_Room;
    
    
	 @NotNull(message=" no_of_floor  can not be empty")
	 @Column(nullable=false)
     private int no_of_floor;
	 
	 
	 @ManyToOne
     @JoinColumn(name="hid")
     private HostelEntity hostel;

    
	
	 @ManyToOne
	 @JoinColumn(name="wid")
	 private WardenEntity warden;
	 
	 @JsonIgnore
	 @OneToMany(mappedBy="floor",cascade=CascadeType.ALL)
	 private List<RoomEntity> roomList=new ArrayList<>();
	 
}
