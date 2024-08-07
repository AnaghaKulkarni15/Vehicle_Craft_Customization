package com.app.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.CustomException.ResourceNotFoundException;
import com.app.dto.ConfigurationDTO;
import com.app.entities.Configuration;
import com.app.repositories.ConfigurationRepository;

@Service
@Transactional
public class ConfigurationServiceImpl implements ConfigurationService {
	
	@Autowired
	private ConfigurationRepository configrepo;

	@Autowired
	private ModelMapper modelmapper ;

	@Override
	public List<ConfigurationDTO> getAllConfigurations() {
		return configrepo.findAll()
				.stream()
				.map(configuration -> modelmapper.map(configuration, ConfigurationDTO.class))
				.collect(Collectors.toList());
	}

//	@Override
//	public Configuration addConfiguration(ConfigurationDTO NewConfiguration) {
//		Configuration configurationEntity = modelmapper.map(NewConfiguration, Configuration.class);
//		Configuration savedconfig= configrepo.save(configurationEntity);
//		return modelmapper.map(savedconfig, Configuration.class);
//	}
	
	@Override
	public Configuration addConfiguration(ConfigurationDTO NewConfiguration) {
	    Configuration configurationEntity = modelmapper.map(NewConfiguration, Configuration.class);
	    Configuration savedconfig = configrepo.save(configurationEntity);
	    return savedconfig;
	}


	@Override
	public String deleteConfig(Long id) {
		if(configrepo.existsById(id)) {
			configrepo.deleteById(id);
			return "Configuration deleted";
		}
		return "Inavlid id..configuration not deleted ";
	}

//	@Override
//	public Configuration updateConfig(Long id , Configuration UpdateConfig) {
//		return configrepo.save(UpdateConfig);
//	}

	@Override
	public ConfigurationDTO updateConfig(long CustomerId, ConfigurationDTO dto) {
		
		Configuration cust = configrepo.findById(CustomerId)
				.orElseThrow(()->new ResourceNotFoundException("Invalid Customer Id !"));
		
		modelmapper.map(dto, cust);
		
		return dto;
	}
	
	

}
