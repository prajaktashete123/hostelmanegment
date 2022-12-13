package com.boot.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResourceNotFoundException extends RuntimeException {
	
	private String resourceName;
	
	private String fieldName;
	
	private int fieldValue;
	
	public ResourceNotFoundException(String resourceName,String fieldName,int fieldValue)
	{
		super(resourceName+"not found with"+fieldName+":"+fieldValue);
		//super(String.format("% not found with %s: %d",resourceName,fieldName,fieldValue));
		this.resourceName=resourceName;
		this.fieldName=fieldName;
		this.fieldValue=fieldValue;
		
		
	}
	
	 

}
