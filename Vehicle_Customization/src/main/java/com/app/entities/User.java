package com.app.entities;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity 
@Table(name="users")
public class User extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	@Column(name="First_name",nullable=false)
	private String fname ;
	
	@Column(name="Last_name",nullable=false)
	private String lname ;
	
	//PRIMARY KEY
	@Column(nullable = false , unique=true)
	private String email ;
	
	@Column(nullable=false)
	private String password ;
	
	@Column(length=12,name="contact_info")
	private String contact;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private Role role ;
	
	
	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY )
	@JoinColumn(name = "order_id" , nullable = false)
	private List<Order> order;
	
	
	
	
}
