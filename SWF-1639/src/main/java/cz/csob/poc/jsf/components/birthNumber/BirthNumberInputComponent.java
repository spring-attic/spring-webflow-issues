package cz.csob.poc.jsf.components.birthNumber;

import java.io.IOException;

import javax.faces.component.FacesComponent;
import javax.faces.component.NamingContainer;
import javax.faces.component.UIInput;
import javax.faces.component.UINamingContainer;
import javax.faces.context.FacesContext;

import cz.csob.poc.jsf.model.BirthNumber;
import cz.csob.poc.jsf.model.converters.form.BirthNumberConverter;


@FacesComponent("birthNumberInput")
public class BirthNumberInputComponent extends UIInput implements NamingContainer {
	
    // Fields -------------------------------------------------------------------------------------

    private UIInput firstPart;
    private UIInput secondPart;
    
    // Actions ------------------------------------------------------------------------------------

    /**
     * Returns the component family of {@link UINamingContainer}.
     * (that's just required by composite component)
     */
    @Override
    public String getFamily() {
        return UINamingContainer.COMPONENT_FAMILY;
    }

    @Override
    public void encodeBegin(FacesContext context) throws IOException {
        BirthNumber birthNumber = (BirthNumber) getValue();
        
        if (isValid()) {
        	
	        if (birthNumber != null && !birthNumber.isEmpty()) {
	        	
		        firstPart.setValue(birthNumber.getFirstPart());
		        secondPart.setValue(birthNumber.getSecondPart());
	        }
        }
        
        super.encodeBegin(context);
    }

    @Override
    public String getSubmittedValue() {
    	
    	String submittedFirstPart = (String) firstPart.getSubmittedValue();
    	String submittedSecondPart = (String) secondPart.getSubmittedValue();
    	
    	if (submittedFirstPart.isEmpty() || submittedSecondPart.isEmpty()) {
    		return "";
    	}
    	
    	StringBuilder birthNumberString = new StringBuilder();
    	birthNumberString.append(submittedFirstPart);
    	birthNumberString.append("/");
    	birthNumberString.append(submittedSecondPart);
    	
    	return birthNumberString.toString();
    }

    @Override
    protected BirthNumber getConvertedValue(FacesContext context, Object submittedValue) {
    	
    	BirthNumberConverter converter = new BirthNumberConverter();
    	BirthNumber birthNumber = (BirthNumber)converter.getAsObject(null, null, (String)submittedValue);
    	
    	return birthNumber;
    }


    // Getters/setters ----------------------------------------------------------------------------

	public UIInput getFirstPart() {
		return firstPart;
	}

	public void setFirstPart(UIInput firstPart) {
		this.firstPart = firstPart;
	}

	public UIInput getSecondPart() {
		return secondPart;
	}

	public void setSecondPart(UIInput secondPart) {
		this.secondPart = secondPart;
	}
}
