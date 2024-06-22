package com.pocket.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Intern extends BaseEntity {

	@Column(length = 75)
	private String name;

	@Column(length = 75)
	private String college;

	@Column(length = 75)
	private String email;

	@Column(length = 75)
	private String city;

	@Column(length = 11, unique = true)
	private String contact;

	private String batch;

}
