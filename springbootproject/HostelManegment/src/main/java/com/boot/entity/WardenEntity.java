package com.boot.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
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
@Table(name="warden_t")
public class WardenEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int wardenId;
	
	
	@NotEmpty( message="warden name can not be empty")
    @Column(nullable=false)
    @Size(min=2,max=10,message="warden name must be minimum 2 characters and maximum 10")
	private String wardenName;
	
	
	 @Email(message ="warden is not valid")
     @NotEmpty(message ="Email can not be empty")
     @Column(nullable=false)
	 private String wardenEmail;
	
	
	@NotNull(message="mobile no can not be empty")
	@Column(nullable=false)
	 @Size(min=2,max=10,message="warden number minimum 2 characters and maximum 10")
	private String wardenMobile;
	
	
	@ManyToOne
    @JoinColumn(name="hid")
    private HostelEntity hostel;
	
	
	
//	 @JsonIgnore
//	 @OneToMany(cascade=CascadeType.ALL)
//	 private List<FloorEntity> floorList1=new ArrayList<>();
	
	
	 @JsonIgnore
	 @OneToMany(mappedBy= "warden",cascade=CascadeType.ALL)
	 private List<FloorEntity> floorList1=new ArrayList<>();
	  
	

}
