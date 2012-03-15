package org.springframework.webflow.issues;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;

public class FileUploadBean implements Serializable {

	private static final long serialVersionUID = -7349430041081627337L;
	
	public void handleFileUpload(FileUploadEvent event) {
		String fileName = event.getFile().getFileName();
		FacesMessage msg = new FacesMessage("Successful", fileName + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		System.out.println("Uploaded file: " + fileName);
	}
}
