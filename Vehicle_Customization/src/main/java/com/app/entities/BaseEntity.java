package com.app.entities;

import java.time.LocalDate;

import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@MappedSuperclass
public class BaseEntity {
	
	@CreationTimestamp
	private LocalDate created_on ;
	
	@UpdateTimestamp
	private LocalDate updated_on ;
}
