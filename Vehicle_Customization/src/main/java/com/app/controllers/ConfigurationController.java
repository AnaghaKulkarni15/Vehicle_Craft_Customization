package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ConfigurationDTO;
import com.app.entities.Configuration;
import com.app.services.ConfigurationService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@RestController
@RequestMapping("/configuration")
public class ConfigurationController {
	
	@Autowired 
	private ConfigurationService configservice ;
	
	@GetMapping
	public ResponseEntity<?> listAllConfiguration(){
		System.out.println("In list all Config");
		return ResponseEntity.ok(configservice.getAllConfigurations());
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addConfiguration(@RequestBody ConfigurationDTO NewConfiguration){
		System.out.println("add config"+NewConfiguration);
		return ResponseEntity.status(HttpStatus.CREATED).body(configservice.addConfiguration(NewConfiguration));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> removeConfiguration(@PathVariable Long id)
	{
		System.out.println("delete config"+id);
		return ResponseEntity.ok(configservice.deleteConfig(id));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateConfiguration(@PathVariable Long id,@RequestBody Configuration updateConfig)
	{
		System.out.println("update configuration"+updateConfig);
		return ResponseEntity.ok(configservice.updateConfig(id, updateConfig));
	}
	
	
	
	
	
	
}
