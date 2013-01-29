package org.springframework.webflow.issues;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import org.richfaces.event.FileUploadEvent;
import org.richfaces.model.UploadedFile;
import org.springframework.webflow.context.ExternalContextHolder;

public class FileUploadBean implements Serializable {

	private static final long serialVersionUID = 1L;

	public void listener(FileUploadEvent event) throws Exception{
        UploadedFile file = event.getUploadedFile();
        FacesContext.getCurrentInstance().getPartialViewContext().processPartial(PhaseId.RENDER_RESPONSE);
        ExternalContextHolder.getExternalContext().recordResponseComplete();
        System.out.println("Uploaded file: " + file.getName());
    }

}
