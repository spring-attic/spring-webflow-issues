package cz.csob.poc.jsf.model.converters.form;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.springframework.binding.convert.converters.InvalidFormatException;

import cz.csob.poc.jsf.model.BirthNumber;

@FacesConverter("BirthNumberConverter")
public class BirthNumberConverter implements Converter {

	public BirthNumberConverter() {
	}

	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		if (value == null || (value.trim().length() == 0)) {
			
			FacesMessage msg = new FacesMessage("Birth number validation failed", "Birth number is required");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ConverterException(msg);
		}
		
		try {
			
			BirthNumber birthNumber = new BirthNumber(value);
			return birthNumber;
			
		} catch (InvalidFormatException ex) {
			
			FacesMessage msg = new FacesMessage("Birth number validation failed", "Invalid Birth number format, expected " + ex.getExpectedFormat());
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ConverterException(msg);
		}
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		BirthNumber birthNumber = null;

		if (value instanceof BirthNumber) {
			birthNumber = (BirthNumber) value;

			return birthNumber.getBirthNumber();
		}
		
		return "";
	}
}
