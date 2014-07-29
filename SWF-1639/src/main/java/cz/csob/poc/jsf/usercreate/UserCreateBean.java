package cz.csob.poc.jsf.usercreate;

import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;

import cz.csob.poc.jsf.components.birthNumber.BirthNumberInputComponent;
import cz.csob.poc.jsf.model.BirthNumber;
import cz.csob.poc.jsf.model.Client;
import cz.csob.poc.jsf.service.IClientService;

@Named
@SessionScoped
//@Component
//@Scope("session")
// need this, JSR-330 in Spring context is singleton by default
public class UserCreateBean {
	
	private Client client;
	
	
	public UserCreateBean() {
		resetBean();
	}
	
	@Inject
	private IClientService clientService;
	
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	public void validateBasicInfo(ComponentSystemEvent event) {
		 
		boolean result = true;
		
		FacesContext fc = FacesContext.getCurrentInstance();
	 
		UIComponent components = event.getComponent();
		  
		// get first name
		UIInput uiInputFirstname = (UIInput) components.findComponent("firstname");
		String firstname = uiInputFirstname.getLocalValue() == null ? "" : uiInputFirstname.getLocalValue().toString();
//		  String firstnameId = uiInputFirstname.getClientId();
	 
		// get last name
		UIInput uiInputLastname = (UIInput) components.findComponent("lastname");
		String lastname= uiInputLastname.getLocalValue() == null ? "" : uiInputLastname.getLocalValue().toString();
		
		// Let required="true" do its job.
		if (!firstname.isEmpty() && !lastname.isEmpty()) {
			
			if (firstname.equals(lastname)) {
		 
				FacesMessage msg = new FacesMessage("Firstname and Surname cannot be same");
				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
				fc.addMessage("clientBasicInfo", msg);
				result = false;
			}
		}
		  
		BirthNumberInputComponent uiInputBirthNumber = (BirthNumberInputComponent) components.findComponent("birthNumber");
		BirthNumber birthNumber = (BirthNumber) uiInputBirthNumber.getLocalValue();
		  
		if (birthNumber != null && !birthNumber.isEmpty()) {
		
			if (birthNumber.getFirstPart() == 781212 && birthNumber.getSecondPart() == 1234) {
			  
			FacesMessage msg = new FacesMessage("Invalid value of birth number");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			fc.addMessage("clientBasicInfo", msg);
			result = false;
			}
		}
		  
		if (!result) {
			fc.renderResponse();
		}
			  
	}
	
	public void validateAdditionalInfo(ComponentSystemEvent event) {
		
	}

	public boolean saveClient() {
		
		try {
			
			clientService.saveClient(client);
			resetBean();
			return true;
			
		} catch (Exception ex) {
			
			return false;
		}
	}
	
	private void resetBean() {
		client = Client.create();
	}
}