package com.pocket.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class InternDTO {

	@JsonProperty(access = Access.READ_WRITE)
	private Long id;
	private String name;
	private String college;
	private String email;
	private String city;
	private String contact;
	private String batch;
	
}
