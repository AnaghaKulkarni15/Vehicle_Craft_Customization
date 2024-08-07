package com.app.services;

import java.util.List;

import com.app.dto.ConfigurationDTO;
import com.app.entities.Configuration;

public interface ConfigurationService {
	
	List<ConfigurationDTO> getAllConfigurations() ;
	
	ConfigurationDTO addConfiguration(ConfigurationDTO NewConfiguration);
	
	String deleteConfig(Long id);
	
	ConfigurationDTO updateConfig(Long id ,ConfigurationDTO updateConfig) ;
	
	
}
