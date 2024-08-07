package com.app.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseDTO {
	
	
	//used during serialization 
	@JsonProperty(access = Access.READ_ONLY)
	private Long id ;
	
	@JsonProperty(access = Access.READ_ONLY)
	private LocalDate creation_date;
	
	@JsonProperty(access = Access.READ_ONLY)
	private LocalDate updated_on ;
}
