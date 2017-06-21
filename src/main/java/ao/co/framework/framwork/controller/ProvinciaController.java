package ao.co.framework.framwork.controller;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import ao.co.framework.framwork.model.Provincia;
import ao.co.framework.framwork.repository.ProvinciaRepository;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Named
@ViewScoped
public class ProvinciaController {

	@Autowired
	private ProvinciaRepository provinciaRepository;
	
	private List<Provincia> provincias;
	
	@PostConstruct
	public void init(){
		provincias = provinciaRepository.findAll();
		
	}
		public List<Provincia> getProvincias(){
			return provincias;
		}
}
