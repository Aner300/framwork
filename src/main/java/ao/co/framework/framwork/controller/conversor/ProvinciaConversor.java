package ao.co.framework.framwork.controller.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ao.co.framework.framwork.model.Provincia;
import ao.co.framework.framwork.repository.ProvinciaRepository;

@Component
public class ProvinciaConversor implements Converter{

	@Autowired
	ProvinciaRepository provinciaRepository;
	
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		if (value.isEmpty()) 
			return null;
		try {
			Provincia provincia = provinciaRepository.findOne(new Integer(value));
			return provincia;
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		
		if (value instanceof Provincia) {
			Provincia provincia = (Provincia) value;
			return provincia.getId().toString();
		}else
		{
			return null;
		}
	}

}
